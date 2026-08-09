package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdmissionRepository extends JpaRepository<Admission, Long> {

    List<Admission> findByPatient_PatientId(Long patientId);

    // Bed_Id වෙනුවට Bed_Number (String) එකට වෙනස් උනා
    List<Admission> findByBed_BedNumber(String bedNumber);

    // දැනට admit වෙලා ඉන්න patients (discharge නොකළ)
    List<Admission> findByDischargeDateIsNull();
}