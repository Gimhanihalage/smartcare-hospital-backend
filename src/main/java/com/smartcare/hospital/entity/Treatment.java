package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "Treatment")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Treatment_ID")
    private Integer treatmentId;

    @NotBlank(message = "Diagnosis is required")
    @Size(max = 255, message = "Diagnosis cannot exceed 255 characters")
    @Column(name = "Diagnosis", length = 255)
    private String diagnosis;

    @Size(max = 500, message = "Prescription details cannot exceed 500 characters")
    @Column(name = "Prescription_Details", length = 500)
    private String prescriptionDetails;

    @Size(max = 500, message = "Treatment notes cannot exceed 500 characters")
    @Column(name = "Treatment_Notes", length = 500)
    private String treatmentNotes;

    @NotNull(message = "Treatment date is required")
    @Column(name = "Treatment_Date")
    private LocalDate treatmentDate;

    @ManyToOne
    @JoinColumn(name = "Appointment_ID", nullable = true)
    private Appointment appointment;

    @NotNull(message = "Patient is required")
    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    @NotNull(message = "Doctor is required")
    @ManyToOne
    @JoinColumn(name = "Doctor_ID", nullable = false)
    private Doctor doctor;

    public Treatment() {
    }

    public Integer getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Integer treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescriptionDetails() {
        return prescriptionDetails;
    }

    public void setPrescriptionDetails(String prescriptionDetails) {
        this.prescriptionDetails = prescriptionDetails;
    }

    public String getTreatmentNotes() {
        return treatmentNotes;
    }

    public void setTreatmentNotes(String treatmentNotes) {
        this.treatmentNotes = treatmentNotes;
    }

    public LocalDate getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(LocalDate treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}