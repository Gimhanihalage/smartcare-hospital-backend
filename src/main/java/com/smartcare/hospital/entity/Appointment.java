package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Appointment_ID")
    private Integer appointmentId;

    @NotNull(message = "Appointment date is required")
    @Column(name = "Appointment_Date")
    private LocalDate appointmentDate;

    @NotNull(message = "Appointment time is required")
    @Column(name = "Appointment_Time")
    private LocalTime appointmentTime;

    @Pattern(regexp = "SCHEDULED|COMPLETED|CANCELLED", message = "Status must be SCHEDULED, COMPLETED, or CANCELLED")
    @Column(name = "Appointment_Status", length = 20)
    private String appointmentStatus;

    @NotBlank(message = "Appointment room is required")
    @Size(max = 20, message = "Room cannot exceed 20 characters")
    @Column(name = "Appointment_Room", length = 20)
    private String appointmentRoom;

    @NotNull(message = "Doctor is required")
    @ManyToOne
    @JoinColumn(name = "Doctor_ID", nullable = false)
    private Doctor doctor;

    @NotNull(message = "Patient is required")
    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    public Appointment() {
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentRoom() {
        return appointmentRoom;
    }

    public void setAppointmentRoom(String appointmentRoom) {
        this.appointmentRoom = appointmentRoom;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}