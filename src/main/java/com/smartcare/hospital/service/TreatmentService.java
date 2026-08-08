package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Treatment;
import com.smartcare.hospital.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;

    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    public List<Treatment> getAll() {
        return treatmentRepository.findAll();
    }

    public Treatment getById(Integer id) {
        return treatmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treatment not found with id: " + id));
    }

    public Treatment save(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }
}