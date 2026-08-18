// File: oopconcept/Bill.java
package com.smartcare.hospital.oopconcept;

import java.util.ArrayList;
import java.util.List;

// ABSTRACTION + POLYMORPHISM: Bill implements the Payable interface, providing concrete
// behavior for the abstract contract defined by Payable
public class Bill implements Payable {
    // ENCAPSULATION: Private fields with controlled access
    private String billId;
    private String billDate;

    // ASSOCIATION: Bill "has-a" Patient (Aggregation)
    private Patient patient;

    // ASSOCIATION: Bill "has-a" list of BillItems (Composition - BillItems belong exclusively to this Bill)
    private List<BillItem> billItems = new ArrayList<>();

    private double discount;
    private double tax;

    // ENCAPSULATION: Constructor initializes all private fields including associated Patient
    public Bill(String billId, String billDate, Patient patient, double discount, double tax) {
        this.billId = billId;
        this.billDate = billDate;
        this.patient = patient; // ASSOCIATION: binding Patient reference
        this.discount = discount;
        this.tax = tax;
    }

    // ENCAPSULATION: Getter for private field 'billId'
    public String getBillId() {
        return billId;
    }

    // ENCAPSULATION: Setter for private field 'billId'
    public void setBillId(String billId) {
        this.billId = billId;
    }

    // ENCAPSULATION: Getter for private field 'billDate'
    public String getBillDate() {
        return billDate;
    }

    // ENCAPSULATION: Setter for private field 'billDate'
    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    // ASSOCIATION: Getter exposing related Patient object
    public Patient getPatient() {
        return patient;
    }

    // ASSOCIATION: Setter to reassign related Patient object
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // ASSOCIATION: Getter exposing the composed list of BillItems
    public List<BillItem> getBillItems() {
        return billItems;
    }

    // ASSOCIATION (COMPOSITION): Adds a BillItem into this Bill's internal collection
    public void addBillItem(BillItem billItem) {
        this.billItems.add(billItem);
    }

    // ENCAPSULATION: Getter for private field 'discount'
    public double getDiscount() {
        return discount;
    }

    // ENCAPSULATION: Setter for private field 'discount'
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // ENCAPSULATION: Getter for private field 'tax'
    public double getTax() {
        return tax;
    }

    // ENCAPSULATION: Setter for private field 'tax'
    public void setTax(double tax) {
        this.tax = tax;
    }

    // POLYMORPHISM + ABSTRACTION: Concrete implementation of the abstract method declared in Payable interface
    @Override
    public double calculateTotal() {
        double subTotal = 0.0;
        // ASSOCIATION: Iterating over composed BillItem objects to sum their amounts
        for (BillItem item : billItems) {
            subTotal += item.getItemAmount();
        }
        double totalAfterTax = subTotal + (subTotal * tax / 100.0);
        double totalAfterDiscount = totalAfterTax - (totalAfterTax * discount / 100.0);
        return totalAfterDiscount;
    }

    // POLYMORPHISM + ABSTRACTION: Concrete implementation of the abstract method declared in Payable interface
    @Override
    public void printBill() {
        System.out.println("======== HOSPITAL BILL ========");
        System.out.println("Bill ID   : " + billId);
        System.out.println("Bill Date : " + billDate);
        // ASSOCIATION: Navigating relationship to get Patient's name
        System.out.println("Patient   : " + (patient != null ? patient.getFirstName() : "N/A"));
        System.out.println("--------------------------------");
        // ASSOCIATION: Iterating over composed BillItem objects to display them
        for (BillItem item : billItems) {
            item.displayItem();
        }
        System.out.println("--------------------------------");
        System.out.println("Discount  : " + discount + "%");
        System.out.println("Tax       : " + tax + "%");
        System.out.println("Total     : " + calculateTotal()); // POLYMORPHISM: calling overridden method
        System.out.println("================================");
    }
}