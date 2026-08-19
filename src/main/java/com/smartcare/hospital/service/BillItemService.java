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

    public BillItem update(Integer id, BillItem billItemDetails) {
        BillItem existing = billItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bill item not found with id: " + id));

        existing.setItemType(billItemDetails.getItemType());
        existing.setDescription(billItemDetails.getDescription());
        existing.setAmount(billItemDetails.getAmount());

        BillItem updated = billItemRepository.save(existing);
        recalculateBillTotal(updated.getBill().getBillId());
        return updated;
    }

    public void delete(Integer id) {
        BillItem item = billItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bill item not found with id: " + id));
        Integer billId = item.getBill().getBillId();
        billItemRepository.deleteById(id);
        recalculateBillTotal(billId);
    }

    private void recalculateBillTotal(Integer billId) {
        List<BillItem> items = billItemRepository.findByBill_BillId(billId);

        BigDecimal total = items.stream()
                .map(BillItem::getAmount)
                .filter(a -> a != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (!billRepository.existsById(billId)) {
            throw new ResourceNotFoundException("Bill not found with id: " + billId);
        }

        billRepository.updateTotalAmount(billId, total);
    }
}