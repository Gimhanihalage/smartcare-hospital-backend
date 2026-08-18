package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Bill_Item")
public class BillItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bill_Item_ID")
    private Integer billItemId;

    @NotBlank(message = "Item type is required")
    @Size(max = 50, message = "Item type cannot exceed 50 characters")
    @Column(name = "Item_Type", length = 50)
    private String itemType;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    @Column(name = "Description", length = 255)
    private String description;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than 0")
    @Digits(integer = 8, fraction = 2, message = "Amount format is invalid")
    @Column(name = "Amount", precision = 10, scale = 2)
    private BigDecimal amount;

    @NotNull(message = "Bill is required")
    @ManyToOne
    @JoinColumn(name = "Bill_ID", nullable = false)
    private Bill bill;

    public BillItem() {
    }

    public Integer getBillItemId() {
        return billItemId;
    }

    public void setBillItemId(Integer billItemId) {
        this.billItemId = billItemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}