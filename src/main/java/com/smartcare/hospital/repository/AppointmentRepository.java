package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.Appointment;
import com.smartcare.hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByDoctorAndAppointmentDateAndAppointmentTime(
            Doctor doctor, LocalDate appointmentDate, LocalTime appointmentTime);
}