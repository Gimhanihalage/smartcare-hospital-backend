// File: oopconcept/Patient.java
package com.smartcare.hospital.oopconcept;

import java.util.ArrayList;
import java.util.List;

// INHERITANCE: Patient extends (inherits from) the abstract Person class
public class Patient extends Person {
    // ENCAPSULATION: Private fields specific to Patient
    private String patientId;
    private String bloodGroup;
    private String symptoms;

    // ASSOCIATION: Patient "has-a" list of Appointments (Aggregation - one-to-many relationship)
    private List<Appointment> appointments = new ArrayList<>();

    // ASSOCIATION: Patient "has-a" list of Treatments (Aggregation - one-to-many relationship)
    private List<Treatment> treatments = new ArrayList<>();

    // INHERITANCE: Constructor calls super() to initialize inherited fields from Person
    public Patient(String name, int age, String gender, String phone, String address,
                   String patientId, String bloodGroup, String symptoms) {
        super(name, age, gender, phone, address); // INHERITANCE: calling parent constructor
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.symptoms = symptoms;
    }

    // ENCAPSULATION: Getter for private field 'patientId'
    public String getPatientId() {
        return patientId;
    }

    // ENCAPSULATION: Setter for private field 'patientId'
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    // ENCAPSULATION: Getter for private field 'bloodGroup'
    public String getBloodGroup() {
        return bloodGroup;
    }

    // ENCAPSULATION: Setter for private field 'bloodGroup'
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    // ENCAPSULATION: Getter for private field 'symptoms'
    public String getSymptoms() {
        return symptoms;
    }

    // ENCAPSULATION: Setter for private field 'symptoms'
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    // ASSOCIATION: Getter exposing the related list of Appointments
    public List<Appointment> getAppointments() {
        return appointments;
    }

    // ASSOCIATION: Method to add an Appointment to this Patient (building the has-a relationship)
    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    // ASSOCIATION: Getter exposing the related list of Treatments
    public List<Treatment> getTreatments() {
        return treatments;
    }

    // ASSOCIATION: Method to add a Treatment to this Patient (building the has-a relationship)
    public void addTreatment(Treatment treatment) {
        this.treatments.add(treatment);
    }

    // POLYMORPHISM: Overriding abstract method displayDetails() from Person (dynamic method dispatch)
    @Override
    public void displayDetails() {
        System.out.println("---- Patient Details ----");
        System.out.println("Patient ID     : " + patientId);
        System.out.println("Name           : " + getFirstName()); // INHERITANCE: using inherited getter
        System.out.println("Age            : " + getAge());       // INHERITANCE: using inherited getter
        System.out.println("Gender         : " + getGender());    // INHERITANCE: using inherited getter
        System.out.println("Phone          : " + getPhone());     // INHERITANCE: using inherited getter
        System.out.println("Address        : " + getAddress());   // INHERITANCE: using inherited getter
        System.out.println("Blood Group    : " + bloodGroup);
        System.out.println("Symptoms       : " + symptoms);
    }
}