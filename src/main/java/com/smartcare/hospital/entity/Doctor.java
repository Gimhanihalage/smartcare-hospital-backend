package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Doctor_ID")
    private Integer doctorId;

    @NotBlank(message = "Doctor name is required")
    @Size(max = 100, message = "Doctor name cannot exceed 100 characters")
    @Column(name = "Doctor_Name", nullable = false, length = 100)
    private String doctorName;

    @Size(max = 100, message = "Specialization cannot exceed 100 characters")
    @Column(name = "Specialization", length = 100)
    private String specialization;

    @Size(max = 100, message = "Qualification cannot exceed 100 characters")
    @Column(name = "Qualification", length = 100)
    private String qualification;

    @Pattern(regexp = "^[0-9+\\-\\s]{7,20}$", message = "Invalid contact number format")
    @Column(name = "Contact_Number", length = 20)
    private String contactNumber;

    @NotNull(message = "Consultation fee is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Consultation fee must be greater than 0")
    @Digits(integer = 8, fraction = 2, message = "Consultation fee format is invalid")
    @Column(name = "Consultation_Fee", precision = 10, scale = 2)
    private BigDecimal consultationFee;

    @ManyToOne
    @JoinColumn(name = "Department_ID")
    @JsonIgnoreProperties({"headDoctor"})
    private Department department;

    public Doctor() {
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public BigDecimal getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(BigDecimal consultationFee) {
        this.consultationFee = consultationFee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}