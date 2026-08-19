package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Bill;
import com.smartcare.hospital.ResourceNotFoundException.java.ResourceNotFoundException;
import com.smartcare.hospital.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    public Bill getById(Integer id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bill not found with id: " + id));
    }

    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }
    public Bill update(Integer id, Bill billDetails) {
        Bill existing = billRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bill not found with id: " + id));

        // Update editable fields only — totalAmount is NOT taken from client,
        // it stays derived from Bill_Items via recalculation
        existing.setBillDate(billDetails.getBillDate());
        existing.setPaymentStatus(billDetails.getPaymentStatus());
        existing.setPaymentMethod(billDetails.getPaymentMethod());

        return billRepository.save(existing);
    }

    public void delete(Integer id) {
        if (!billRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bill not found with id: " + id);
        }
        billRepository.deleteById(id);
    }
}