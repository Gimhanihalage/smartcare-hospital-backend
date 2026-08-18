// File: oopconcept/Admission.java
package com.smartcare.hospital.oopconcept;

public class Admission {
    // ENCAPSULATION: Private fields with controlled access
    private String admissionId;
    private String admissionDate;
    private String dischargeDate;

    // ASSOCIATION: Admission "has-a" Patient (Aggregation)
    private Patient patient;

    // ASSOCIATION: Admission "has-a" Room (Aggregation)
    private Room room;

    // ASSOCIATION: Admission "has-a" Bed (Aggregation)
    private Bed bed;

    private int numberOfDays;

    // ENCAPSULATION: Constructor initializes all private fields including associated objects
    public Admission(String admissionId, String admissionDate, String dischargeDate,
                     Patient patient, Room room, Bed bed, int numberOfDays) {
        this.admissionId = admissionId;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.patient = patient; // ASSOCIATION: binding Patient reference
        this.room = room;       // ASSOCIATION: binding Room reference
        this.bed = bed;         // ASSOCIATION: binding Bed reference
        this.numberOfDays = numberOfDays;
        if (bed != null) {
            // ASSOCIATION: interacting with the associated Bed object to change its state
            bed.setOccupied(true);
        }
    }

    // ENCAPSULATION: Getter for private field 'admissionId'
    public String getAdmissionId() {
        return admissionId;
    }

    // ENCAPSULATION: Setter for private field 'admissionId'
    public void setAdmissionId(String admissionId) {
        this.admissionId = admissionId;
    }

    // ENCAPSULATION: Getter for private field 'admissionDate'
    public String getAdmissionDate() {
        return admissionDate;
    }

    // ENCAPSULATION: Setter for private field 'admissionDate'
    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    // ENCAPSULATION: Getter for private field 'dischargeDate'
    public String getDischargeDate() {
        return dischargeDate;
    }

    // ENCAPSULATION: Setter for private field 'dischargeDate'
    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    // ASSOCIATION: Getter exposing related Patient object
    public Patient getPatient() {
        return patient;
    }

    // ASSOCIATION: Setter to reassign related Patient object
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // ASSOCIATION: Getter exposing related Room object
    public Room getRoom() {
        return room;
    }

    // ASSOCIATION: Setter to reassign related Room object
    public void setRoom(Room room) {
        this.room = room;
    }

    // ASSOCIATION: Getter exposing related Bed object
    public Bed getBed() {
        return bed;
    }

    // ASSOCIATION: Setter to reassign related Bed object
    public void setBed(Bed bed) {
        this.bed = bed;
    }

    // ENCAPSULATION: Getter for private field 'numberOfDays'
    public int getNumberOfDays() {
        return numberOfDays;
    }

    // ENCAPSULATION: Setter for private field 'numberOfDays'
    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    // ASSOCIATION: Uses the related Room object's data to compute a derived value
    public double calculateRoomCharge() {
        if (room == null) {
            return 0.0;
        }
        return room.getRoomChargePerDay() * numberOfDays;
    }

    public void displayAdmission() {
        System.out.println("---- Admission Details ----");
        System.out.println("Admission ID    : " + admissionId);
        System.out.println("Admission Date  : " + admissionDate);
        System.out.println("Discharge Date  : " + dischargeDate);
        // ASSOCIATION: Navigating relationship to get Patient's name
        System.out.println("Patient         : " + (patient != null ? patient.getFirstName() : "N/A"));
        // ASSOCIATION: Navigating relationship to get Room's number
        System.out.println("Room Number     : " + (room != null ? room.getRoomNumber() : "N/A"));
        // ASSOCIATION: Navigating relationship to get Bed's ID
        System.out.println("Bed ID          : " + (bed != null ? bed.getBedId() : "N/A"));
        System.out.println("Number of Days  : " + numberOfDays);
        System.out.println("Room Charge     : " + calculateRoomCharge());
    }
}