package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Bill b SET b.totalAmount = :total WHERE b.billId = :billId")
    void updateTotalAmount(@Param("billId") Integer billId, @Param("total") BigDecimal total);
}