// File: oopconcept/BillItem.java
package com.smartcare.hospital.oopconcept;

public class BillItem {
    // ENCAPSULATION: Private fields with controlled access
    private String itemId;
    private String itemDescription;
    private double itemAmount;

    // ENCAPSULATION: Constructor initializes private fields
    public BillItem(String itemId, String itemDescription, double itemAmount) {
        this.itemId = itemId;
        this.itemDescription = itemDescription;
        this.itemAmount = itemAmount;
    }

    // ENCAPSULATION: Getter for private field 'itemId'
    public String getItemId() {
        return itemId;
    }

    // ENCAPSULATION: Setter for private field 'itemId'
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    // ENCAPSULATION: Getter for private field 'itemDescription'
    public String getItemDescription() {
        return itemDescription;
    }

    // ENCAPSULATION: Setter for private field 'itemDescription'
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    // ENCAPSULATION: Getter for private field 'itemAmount'
    public double getItemAmount() {
        return itemAmount;
    }

    // ENCAPSULATION: Setter for private field 'itemAmount'
    public void setItemAmount(double itemAmount) {
        this.itemAmount = itemAmount;
    }

    public void displayItem() {
        System.out.println(itemId + " - " + itemDescription + " : " + itemAmount);
    }
}