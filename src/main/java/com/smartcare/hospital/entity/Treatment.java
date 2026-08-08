package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Treatment")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Treatment_ID")
    private Integer treatmentId;

    @Column(name = "Diagnosis", length = 255)
    private String diagnosis;

    @Column(name = "Prescription_Details", length = 500)
    private String prescriptionDetails;

    @Column(name = "Treatment_Notes", length = 500)
    private String treatmentNotes;

    @Column(name = "Treatment_Date")
    private LocalDate treatmentDate;

    @ManyToOne
    @JoinColumn(name = "Appointment_ID", nullable = false)
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "Bill_ID", nullable = false)
    private Bill bill;

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

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
