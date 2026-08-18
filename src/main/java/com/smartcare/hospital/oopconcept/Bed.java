// File: oopconcept/Bed.java
package com.smartcare.hospital.oopconcept;

public class Bed {
    // ENCAPSULATION: Private fields, accessed only via public methods
    private String bedId;
    private String bedType;
    private boolean isOccupied;

    // ENCAPSULATION: Constructor initializes private fields
    public Bed(String bedId, String bedType) {
        this.bedId = bedId;
        this.bedType = bedType;
        this.isOccupied = false;
    }

    // ENCAPSULATION: Getter for private field 'bedId'
    public String getBedId() {
        return bedId;
    }

    // ENCAPSULATION: Setter for private field 'bedId'
    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    // ENCAPSULATION: Getter for private field 'bedType'
    public String getBedType() {
        return bedType;
    }

    // ENCAPSULATION: Setter for private field 'bedType'
    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    // ENCAPSULATION: Getter for private field 'isOccupied'
    public boolean isOccupied() {
        return isOccupied;
    }

    // ENCAPSULATION: Setter for private field 'isOccupied'
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void displayBed() {
        System.out.println("Bed ID: " + bedId + " | Type: " + bedType + " | Occupied: " + isOccupied);
    }
}