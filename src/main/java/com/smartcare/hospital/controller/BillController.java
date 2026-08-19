package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Bill;
import com.smartcare.hospital.service.BillService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Integer id) {
        return ResponseEntity.ok(billService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Bill> createBill(@Valid @RequestBody Bill bill) {
        Bill saved = billService.save(bill);
        return ResponseEntity.ok(saved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable Integer id, @Valid @RequestBody Bill bill) {
        Bill updated = billService.update(id, bill);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Integer id) {
        billService.delete(id);
        return ResponseEntity.noContent().build();
    }
}