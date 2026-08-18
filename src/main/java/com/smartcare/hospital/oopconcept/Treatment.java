// File: oopconcept/Treatment.java
package com.smartcare.hospital.oopconcept;

public class Treatment {
    // ENCAPSULATION: Private fields with controlled access
    private String treatmentId;
    private String treatmentName;
    private String treatmentDate;
    private double treatmentCost;

    // ASSOCIATION: Treatment "has-a" Patient (Aggregation)
    private Patient patient;

    // ASSOCIATION: Treatment "has-a" Doctor (Aggregation)
    private Doctor doctor;

    // ENCAPSULATION: Constructor initializes all private fields including associated objects
    public Treatment(String treatmentId, String treatmentName, String treatmentDate,
                     double treatmentCost, Patient patient, Doctor doctor) {
        this.treatmentId = treatmentId;
        this.treatmentName = treatmentName;
        this.treatmentDate = treatmentDate;
        this.treatmentCost = treatmentCost;
        this.patient = patient; // ASSOCIATION: binding Patient reference
        this.doctor = doctor;   // ASSOCIATION: binding Doctor reference
    }

    // ENCAPSULATION: Getter for private field 'treatmentId'
    public String getTreatmentId() {
        return treatmentId;
    }

    // ENCAPSULATION: Setter for private field 'treatmentId'
    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    // ENCAPSULATION: Getter for private field 'treatmentName'
    public String getTreatmentName() {
        return treatmentName;
    }

    // ENCAPSULATION: Setter for private field 'treatmentName'
    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    // ENCAPSULATION: Getter for private field 'treatmentDate'
    public String getTreatmentDate() {
        return treatmentDate;
    }

    // ENCAPSULATION: Setter for private field 'treatmentDate'
    public void setTreatmentDate(String treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    // ENCAPSULATION: Getter for private field 'treatmentCost'
    public double getTreatmentCost() {
        return treatmentCost;
    }

    // ENCAPSULATION: Setter for private field 'treatmentCost'
    public void setTreatmentCost(double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    // ASSOCIATION: Getter exposing related Patient object
    public Patient getPatient() {
        return patient;
    }

    // ASSOCIATION: Setter to reassign related Patient object
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // ASSOCIATION: Getter exposing related Doctor object
    public Doctor getDoctor() {
        return doctor;
    }

    // ASSOCIATION: Setter to reassign related Doctor object
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void displayTreatment() {
        System.out.println("---- Treatment Details ----");
        System.out.println("Treatment ID    : " + treatmentId);
        System.out.println("Treatment Name  : " + treatmentName);
        System.out.println("Treatment Date  : " + treatmentDate);
        System.out.println("Treatment Cost  : " + treatmentCost);
        // ASSOCIATION: Navigating relationship to get Patient's name
        System.out.println("Patient         : " + (patient != null ? patient.getFirstName() : "N/A"));
        // ASSOCIATION: Navigating relationship to get Doctor's name
        System.out.println("Doctor          : " + (doctor != null ? ("Dr. " + doctor.getFirstName()) : "N/A"));
    }
}