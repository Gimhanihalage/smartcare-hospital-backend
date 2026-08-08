package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bill_ID")
    private Integer billId;

    @Column(name = "Bill_Date")
    private LocalDate billDate;

    @Column(name = "Total_Amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "Payment_Status", length = 20)
    private String paymentStatus;

    @Column(name = "Payment_Method", length = 30)
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "Admission_ID", nullable = true)
    private Admission admission;

    @ManyToOne
    @JoinColumn(name = "Appointment_ID", nullable = true)
    private Appointment appointment;

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
}