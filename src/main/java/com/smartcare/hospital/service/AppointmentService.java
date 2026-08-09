package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Appointment;
import com.smartcare.hospital.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public Appointment getById(Integer id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Appointment not found with ID: " + id));
    }

    public Appointment save(Appointment appointment) {

        // 1. Past date validation
        if (appointment.getAppointmentDate() != null &&
                appointment.getAppointmentDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Cannot book an appointment on a past date.");
        }

        // 2. Double-booking check - same doctor, same date, same time
        List<Appointment> existing = appointmentRepository.findByDoctorAndAppointmentDateAndAppointmentTime(
                appointment.getDoctor(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime()
        );

        boolean isDuplicate = existing.stream()
                .anyMatch(a -> !a.getAppointmentId().equals(appointment.getAppointmentId()));

        if (isDuplicate) {
            throw new IllegalArgumentException("This doctor already has an appointment at the selected date and time.");
        }

        // 3. Default status if not provided
        if (appointment.getAppointmentStatus() == null || appointment.getAppointmentStatus().isBlank()) {
            appointment.setAppointmentStatus("SCHEDULED");
        }

        return appointmentRepository.save(appointment);
    }

    public void delete(Integer id) {
        if (!appointmentRepository.existsById(id)) {
            throw new NoSuchElementException("Appointment not found with ID: " + id);
        }
        appointmentRepository.deleteById(id);
    }
}