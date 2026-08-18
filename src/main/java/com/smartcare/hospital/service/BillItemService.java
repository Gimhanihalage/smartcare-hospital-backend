package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Bill;
import com.smartcare.hospital.entity.BillItem;
import com.smartcare.hospital.ResourceNotFoundException.java.ResourceNotFoundException;
import com.smartcare.hospital.repository.BillItemRepository;
import com.smartcare.hospital.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BillItemService {

    private final BillItemRepository billItemRepository;
    private final BillRepository billRepository;

    public BillItemService(BillItemRepository billItemRepository, BillRepository billRepository) {
        this.billItemRepository = billItemRepository;
        this.billRepository = billRepository;
    }

    public List<BillItem> getAll() {
        return billItemRepository.findAll();
    }

    public BillItem getById(Integer id) {
        return billItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bill item not found with id: " + id));
    }

    public BillItem save(BillItem billItem) {
        BillItem saved = billItemRepository.save(billItem);
        recalculateBillTotal(saved.getBill().getBillId());
        return saved;
    }

    public void delete(Integer id) {
        BillItem item = billItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bill item not found with id: " + id));
        Integer billId = item.getBill().getBillId();
        billItemRepository.deleteById(id);
        recalculateBillTotal(billId);
    }

    // Business logic - recalculate Bill's total amount from all its BillItems
    private void recalculateBillTotal(Integer billId) {
        List<BillItem> items = billItemRepository.findByBill_BillId(billId);

        BigDecimal total = items.stream()
                .map(BillItem::getAmount)
                .filter(a -> a != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new ResourceNotFoundException("Bill not found with id: " + billId));

        bill.setTotalAmount(total);
        billRepository.save(bill);
    }
}