package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Laboratory;
import com.smartcare.hospital.ResourceNotFoundException.java.ResourceNotFoundException;
import com.smartcare.hospital.repository.LaboratoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryService {

    private final LaboratoryRepository laboratoryRepository;

    public LaboratoryService(LaboratoryRepository laboratoryRepository) {
        this.laboratoryRepository = laboratoryRepository;
    }

    public List<Laboratory> getAll() {
        return laboratoryRepository.findAll();
    }

    public Laboratory getById(Integer id) {
        return laboratoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab test not found with id: " + id));
    }

    public Laboratory saveLaboratory(Laboratory laboratory) {
        if (laboratory.getTestDate() != null &&
                laboratory.getTestDate().isAfter(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("Test date cannot be in the future.");
        }
        if (laboratory.getTestStatus() == null || laboratory.getTestStatus().isBlank()) {
            laboratory.setTestStatus("PENDING");
        }
        return laboratoryRepository.save(laboratory);
    }

    public Laboratory update(Integer id, Laboratory labTest) {
        Laboratory existing = laboratoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab test not found with id: " + id));

        existing.setTestName(labTest.getTestName());
        existing.setTestDate(labTest.getTestDate());
        existing.setTestResult(labTest.getTestResult());
        existing.setTestStatus(labTest.getTestStatus());
        existing.setTechnicianName(labTest.getTechnicianName());
        existing.setPatient(labTest.getPatient());
        existing.setDoctor(labTest.getDoctor());

        return laboratoryRepository.save(existing);
    }

    public void delete(Integer id) {
        if (!laboratoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Lab test not found with id: " + id);
        }
        laboratoryRepository.deleteById(id);
    }
}