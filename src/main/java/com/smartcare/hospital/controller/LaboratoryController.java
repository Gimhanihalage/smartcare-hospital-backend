package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Laboratory;
import com.smartcare.hospital.service.LaboratoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lab-tests")
public class LaboratoryController {

    private final LaboratoryService laboratoryService;

    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @GetMapping
    public ResponseEntity<List<Laboratory>> getAllLabTests() {
        return ResponseEntity.ok(laboratoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratory> getLabTestById(@PathVariable Integer id) {
        return ResponseEntity.ok(laboratoryService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Laboratory> createLabTest(@RequestBody Laboratory labTest) {
        Laboratory saved = laboratoryService.save(labTest);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laboratory> updateLabTest(@PathVariable Integer id, @RequestBody Laboratory labTest) {
        Laboratory updated = laboratoryService.update(id, labTest);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLabTest(@PathVariable Integer id) {
        laboratoryService.delete(id);
        return ResponseEntity.ok("Lab test deleted successfully with ID: " + id);
    }
}