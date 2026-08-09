package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Admission;
import com.smartcare.hospital.repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepository admissionRepository;

    public Admission admitPatient(Admission admission) {
        return admissionRepository.save(admission);
    }

    public Admission dischargePatient(Long id) {
        Admission admission = admissionRepository.findById(id).orElse(null);
        if (admission != null) {
            // අවශ්‍ය නම් මෙහිදී discharge status වෙනස් කළ හැක
            return admissionRepository.save(admission);
        }
        return null;
    }

    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }
}