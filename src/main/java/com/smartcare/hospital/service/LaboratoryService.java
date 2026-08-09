package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Laboratory;
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
                .orElseThrow(() -> new RuntimeException("Lab test not found with id: " + id));
    }

    public Laboratory save(Laboratory labTest) {
        // Default status if not provided
        if (labTest.getTestStatus() == null || labTest.getTestStatus().isBlank()) {
            labTest.setTestStatus("PENDING");
        }
        return laboratoryRepository.save(labTest);
    }

    public Laboratory update(Integer id, Laboratory labTest) {
        Laboratory existing = laboratoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lab test not found with id: " + id));

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
            throw new RuntimeException("Lab test not found with id: " + id);
        }
        laboratoryRepository.deleteById(id);
    }
}