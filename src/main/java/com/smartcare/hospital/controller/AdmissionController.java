package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Admission;
import com.smartcare.hospital.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admissions")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    // 1. Admit Patient (POST)
    @PostMapping
    public Admission admit(@RequestBody Admission admission) {
        return admissionService.admitPatient(admission);
    }

    // 2. Discharge Patient (PUT)
    @PutMapping("/{id}/discharge")
    public Admission discharge(@PathVariable Long id) {
        return admissionService.dischargePatient(id);
    }

    // 3. Get All Admissions (GET)
    @GetMapping
    public List<Admission> getAllAdmissions() {
        return admissionService.getAllAdmissions();
    }
}