// File: oopconcept/Department.java
package com.smartcare.hospital.oopconcept;

import java.util.ArrayList;
import java.util.List;

public class Department {
    // ENCAPSULATION: Private fields with controlled access
    private String departmentId;
    private String departmentName;

    // ASSOCIATION: Department "has-a" list of Doctors (Aggregation - Doctors can exist without Department)
    private List<Doctor> doctors = new ArrayList<>();

    // ENCAPSULATION: Constructor to initialize private fields
    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    // ENCAPSULATION: Getter for private field 'departmentId'
    public String getDepartmentId() {
        return departmentId;
    }

    // ENCAPSULATION: Setter for private field 'departmentId'
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    // ENCAPSULATION: Getter for private field 'departmentName'
    public String getDepartmentName() {
        return departmentName;
    }

    // ENCAPSULATION: Setter for private field 'departmentName'
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // ASSOCIATION: Getter exposing the related list of Doctors (Aggregation)
    public List<Doctor> getDoctors() {
        return doctors;
    }

    // ASSOCIATION: Method builds the two-way Aggregation relationship between Department and Doctor
    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
        doctor.setDepartment(this); // ASSOCIATION: linking back Doctor -> Department
    }

    public void displayDepartment() {
        System.out.println("---- Department Details ----");
        System.out.println("Department ID  : " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Total Doctors  : " + doctors.size());
        // ASSOCIATION: Iterating over aggregated Doctor objects
        for (Doctor d : doctors) {
            System.out.println("  - Dr. " + d.getFirstName() + " (" + d.getSpecialization() + ")");
        }
    }
}