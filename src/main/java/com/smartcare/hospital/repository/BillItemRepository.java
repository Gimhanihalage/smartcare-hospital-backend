package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillItemRepository extends JpaRepository<BillItem, Integer> {
    List<BillItem> findByBill_BillId(Integer billId);
}