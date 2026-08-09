package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Admission;
import com.smartcare.hospital.repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepository admissionRepository;

    public Admission admitPatient(Admission admission) {
        return admissionRepository.save(admission);
    }

    public Admission dischargePatient(Integer id) {
        Admission admission = admissionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Admission not found with ID: " + id));

        // Actual discharge logic - update fields
        admission.setDischargeDate(LocalDate.now());
        admission.setAdmissionStatus("DISCHARGED");

        return admissionRepository.save(admission);
    }

    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }

    public Admission getAdmissionById(Integer id) {
        return admissionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Admission not found with ID: " + id));
    }
}