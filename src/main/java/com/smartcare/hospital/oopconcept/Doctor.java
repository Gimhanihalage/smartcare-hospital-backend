// File: oopconcept/Doctor.java
package com.smartcare.hospital.oopconcept;

// INHERITANCE: Doctor extends (inherits from) the abstract Person class
public class Doctor extends Person {
    // ENCAPSULATION: Private fields specific to Doctor
    private String doctorId;
    private String specialization;
    private double consultationFee;

    // ASSOCIATION: Doctor "has-a" Department (Aggregation - Doctor can exist independently of Department)
    private Department department;

    // INHERITANCE: Constructor calls super() to initialize inherited fields from Person
    public Doctor(String name, int age, String gender, String phone, String address,
                  String doctorId, String specialization, double consultationFee) {
        super(name, age, gender, phone, address); // INHERITANCE: calling parent constructor
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    // ENCAPSULATION: Getter for private field 'doctorId'
    public String getDoctorId() {
        return doctorId;
    }

    // ENCAPSULATION: Setter for private field 'doctorId'
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    // ENCAPSULATION: Getter for private field 'specialization'
    public String getSpecialization() {
        return specialization;
    }

    // ENCAPSULATION: Setter for private field 'specialization'
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // ENCAPSULATION: Getter for private field 'consultationFee'
    public double getConsultationFee() {
        return consultationFee;
    }

    // ENCAPSULATION: Setter for private field 'consultationFee'
    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    // ASSOCIATION: Getter exposing the related Department object (Aggregation)
    public Department getDepartment() {
        return department;
    }

    // ASSOCIATION: Setter to link this Doctor to a Department (Aggregation)
    public void setDepartment(Department department) {
        this.department = department;
    }

    // POLYMORPHISM: Overriding abstract method displayDetails() from Person (dynamic method dispatch)
    @Override
    public void displayDetails() {
        System.out.println("---- Doctor Details ----");
        System.out.println("Doctor ID       : " + doctorId);
        System.out.println("Name            : Dr. " + getFirstName()); // INHERITANCE: using inherited getter
        System.out.println("Age             : " + getAge());           // INHERITANCE: using inherited getter
        System.out.println("Gender          : " + getGender());       // INHERITANCE: using inherited getter
        System.out.println("Phone           : " + getPhone());        // INHERITANCE: using inherited getter
        System.out.println("Address         : " + getAddress());      // INHERITANCE: using inherited getter
        System.out.println("Specialization  : " + specialization);
        System.out.println("Consultation Fee: " + consultationFee);
        if (department != null) {
            // ASSOCIATION: Navigating relationship to Department object
            System.out.println("Department      : " + department.getDepartmentName());
        }
    }
}