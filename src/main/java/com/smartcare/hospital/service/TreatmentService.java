package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Treatment;
import com.smartcare.hospital.ResourceNotFoundException.java.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException("Treatment not found with id: " + id));
    }

    public Treatment save(Treatment treatment) {
        if (treatment.getTreatmentDate() != null &&
                treatment.getTreatmentDate().isAfter(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("Treatment date cannot be in the future.");
        }
        return treatmentRepository.save(treatment);
    }

    public Treatment update(Integer id, Treatment treatment) {
        Treatment existing = treatmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Treatment not found with id: " + id));

        existing.setDiagnosis(treatment.getDiagnosis());
        existing.setPrescriptionDetails(treatment.getPrescriptionDetails());
        existing.setTreatmentNotes(treatment.getTreatmentNotes());
        existing.setTreatmentDate(treatment.getTreatmentDate());
        existing.setAppointment(treatment.getAppointment());
        existing.setPatient(treatment.getPatient());
        existing.setDoctor(treatment.getDoctor());

        return treatmentRepository.save(existing);
    }

    public void delete(Integer id) {
        if (!treatmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Treatment not found with id: " + id);
        }
        treatmentRepository.deleteById(id);
    }
}