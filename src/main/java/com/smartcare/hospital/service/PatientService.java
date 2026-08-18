package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Patient;
import com.smartcare.hospital.ResourceNotFoundException.java.ResourceNotFoundException;
import com.smartcare.hospital.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient getById(Integer id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient update(Integer id, Patient patient) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

        existing.setFirstName(patient.getFirstName());
        existing.setLastName(patient.getLastName());
        existing.setDateOfBirth(patient.getDateOfBirth());
        existing.setGender(patient.getGender());
        existing.setAddress(patient.getAddress());
        existing.setBloodGroup(patient.getBloodGroup());
        existing.setEmergencyContactInformation(patient.getEmergencyContactInformation());

        return patientRepository.save(existing);
    }

    public void delete(Integer id) {
        if (!patientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }
}