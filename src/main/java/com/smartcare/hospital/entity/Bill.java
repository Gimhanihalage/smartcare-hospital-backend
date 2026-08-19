package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bill_ID")
    private Integer billId;

    @NotNull(message = "Bill date is required")
    @PastOrPresent(message = "Bill date cannot be in the future")
    @Column(name = "Bill_Date")
    private LocalDate billDate;

    @NotNull(message = "Total amount is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Total amount cannot be negative")
    @Digits(integer = 8, fraction = 2, message = "Total amount format is invalid")
    @Column(name = "Total_Amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @NotBlank(message = "Payment status is required")
    @Pattern(regexp = "Paid|Unpaid|Partially Paid", message = "Payment status must be Paid, Unpaid, or Partially Paid")
    @Column(name = "Payment_Status", length = 20)
    private String paymentStatus;

    @Size(max = 30, message = "Payment method cannot exceed 30 characters")
    @Column(name = "Payment_Method", length = 30)
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "Admission_ID", nullable = true)
    private Admission admission;

    @ManyToOne
    @JoinColumn(name = "Appointment_ID", nullable = true)
    private Appointment appointment;

    @NotNull(message = "Patient is required")
    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    public Bill() {
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
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
}