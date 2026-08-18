package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "Laboratory")
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LabTest_ID")
    private Integer labTestId;

    @NotBlank(message = "Test name is required")
    @Size(max = 100, message = "Test name cannot exceed 100 characters")
    @Column(name = "Test_Name", length = 100)
    private String testName;

    @NotNull(message = "Test date is required")
    @Column(name = "Test_Date")
    private LocalDate testDate;

    @Size(max = 255, message = "Test result cannot exceed 255 characters")
    @Column(name = "Test_Result", length = 255)
    private String testResult;

    @Pattern(regexp = "PENDING|COMPLETED|CANCELLED", message = "Test status must be PENDING, COMPLETED, or CANCELLED")
    @Column(name = "Test_Status", length = 20)
    private String testStatus;

    @Size(max = 100, message = "Technician name cannot exceed 100 characters")
    @Column(name = "Technician_Name", length = 100)
    private String technicianName;

    @NotNull(message = "Patient is required")
    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    @NotNull(message = "Doctor is required")
    @ManyToOne
    @JoinColumn(name = "Doctor_ID", nullable = false)
    private Doctor doctor;

    public Laboratory() {
    }

    public Integer getLabTestId() {
        return labTestId;
    }

    public void setLabTestId(Integer labTestId) {
        this.labTestId = labTestId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

    public String getTechnicianName() {
        return technicianName;
    }

    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
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