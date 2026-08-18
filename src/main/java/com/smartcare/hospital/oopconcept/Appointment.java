// File: oopconcept/Appointment.java
package com.smartcare.hospital.oopconcept;

public class Appointment {
    // ENCAPSULATION: Private fields with controlled access
    private String appointmentId;
    private String appointmentDate;
    private String appointmentTime;

    // ASSOCIATION: Appointment "has-a" Patient (Aggregation - links two independent objects)
    private Patient patient;

    // ASSOCIATION: Appointment "has-a" Doctor (Aggregation - links two independent objects)
    private Doctor doctor;

    private String status;

    // ENCAPSULATION: Constructor initializes all private fields, including associated objects
    public Appointment(String appointmentId, String appointmentDate, String appointmentTime,
                       Patient patient, Doctor doctor, String status) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.patient = patient; // ASSOCIATION: binding Patient reference
        this.doctor = doctor;   // ASSOCIATION: binding Doctor reference
        this.status = status;
    }

    // ENCAPSULATION: Getter for private field 'appointmentId'
    public String getAppointmentId() {
        return appointmentId;
    }

    // ENCAPSULATION: Setter for private field 'appointmentId'
    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    // ENCAPSULATION: Getter for private field 'appointmentDate'
    public String getAppointmentDate() {
        return appointmentDate;
    }

    // ENCAPSULATION: Setter for private field 'appointmentDate'
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    // ENCAPSULATION: Getter for private field 'appointmentTime'
    public String getAppointmentTime() {
        return appointmentTime;
    }

    // ENCAPSULATION: Setter for private field 'appointmentTime'
    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
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

    // ENCAPSULATION: Getter for private field 'status'
    public String getStatus() {
        return status;
    }

    // ENCAPSULATION: Setter for private field 'status'
    public void setStatus(String status) {
        this.status = status;
    }

    public void displayAppointment() {
        System.out.println("---- Appointment Details ----");
        System.out.println("Appointment ID  : " + appointmentId);
        System.out.println("Date            : " + appointmentDate);
        System.out.println("Time            : " + appointmentTime);
        // ASSOCIATION: Navigating relationship to get Patient's name
        System.out.println("Patient         : " + (patient != null ? patient.getFirstName() : "N/A"));
        // ASSOCIATION: Navigating relationship to get Doctor's name
        System.out.println("Doctor          : " + (doctor != null ? ("Dr. " + doctor.getFirstName()) : "N/A"));
        System.out.println("Status          : " + status);
    }
}