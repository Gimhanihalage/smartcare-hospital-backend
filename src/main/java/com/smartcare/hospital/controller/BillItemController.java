package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.BillItem;
import com.smartcare.hospital.service.BillItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill-items")
public class BillItemController {

    private final BillItemService billItemService;

    public BillItemController(BillItemService billItemService) {
        this.billItemService = billItemService;
    }

    @GetMapping
    public ResponseEntity<List<BillItem>> getAllBillItems() {
        return ResponseEntity.ok(billItemService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillItem> getBillItemById(@PathVariable Integer id) {
        return ResponseEntity.ok(billItemService.getById(id));
    }

    @PostMapping
    public ResponseEntity<BillItem> createBillItem(@Valid @RequestBody BillItem billItem) {
        BillItem saved = billItemService.save(billItem);
        return ResponseEntity.ok(saved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BillItem> updateBillItem(@PathVariable Integer id, @Valid @RequestBody BillItem billItem) {
        BillItem updated = billItemService.update(id, billItem);
        return ResponseEntity.ok(updated);
    }
}