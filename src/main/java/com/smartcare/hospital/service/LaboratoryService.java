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
        return laboratoryRepository.save(labTest);
    }
}
