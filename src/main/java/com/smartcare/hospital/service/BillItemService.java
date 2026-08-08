package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.BillItem;
import com.smartcare.hospital.repository.BillItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillItemService {

    private final BillItemRepository billItemRepository;

    public BillItemService(BillItemRepository billItemRepository) {
        this.billItemRepository = billItemRepository;
    }

    public List<BillItem> getAll() {
        return billItemRepository.findAll();
    }

    public BillItem getById(Integer id) {
        return billItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill item not found with id: " + id));
    }

    public BillItem save(BillItem billItem) {
        return billItemRepository.save(billItem);
    }
}