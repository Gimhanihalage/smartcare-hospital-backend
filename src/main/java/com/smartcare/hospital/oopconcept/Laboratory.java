// File: oopconcept/Laboratory.java
package com.smartcare.hospital.oopconcept;

public class Laboratory {
    // ENCAPSULATION: Private fields with controlled access
    private String testId;
    private String testName;
    private String testDate;
    private double testCost;
    private String testResult;

    // ASSOCIATION: Laboratory test "has-a" Patient (Aggregation)
    private Patient patient;

    // ENCAPSULATION: Constructor initializes all private fields including associated Patient
    public Laboratory(String testId, String testName, String testDate, double testCost,
                      String testResult, Patient patient) {
        this.testId = testId;
        this.testName = testName;
        this.testDate = testDate;
        this.testCost = testCost;
        this.testResult = testResult;
        this.patient = patient; // ASSOCIATION: binding Patient reference
    }

    // ENCAPSULATION: Getter for private field 'testId'
    public String getTestId() {
        return testId;
    }

    // ENCAPSULATION: Setter for private field 'testId'
    public void setTestId(String testId) {
        this.testId = testId;
    }

    // ENCAPSULATION: Getter for private field 'testName'
    public String getTestName() {
        return testName;
    }

    // ENCAPSULATION: Setter for private field 'testName'
    public void setTestName(String testName) {
        this.testName = testName;
    }

    // ENCAPSULATION: Getter for private field 'testDate'
    public String getTestDate() {
        return testDate;
    }

    // ENCAPSULATION: Setter for private field 'testDate'
    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    // ENCAPSULATION: Getter for private field 'testCost'
    public double getTestCost() {
        return testCost;
    }

    // ENCAPSULATION: Setter for private field 'testCost'
    public void setTestCost(double testCost) {
        this.testCost = testCost;
    }

    // ENCAPSULATION: Getter for private field 'testResult'
    public String getTestResult() {
        return testResult;
    }

    // ENCAPSULATION: Setter for private field 'testResult'
    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    // ASSOCIATION: Getter exposing related Patient object
    public Patient getPatient() {
        return patient;
    }

    // ASSOCIATION: Setter to reassign related Patient object
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void displayLabTest() {
        System.out.println("---- Laboratory Test Details ----");
        System.out.println("Test ID     : " + testId);
        System.out.println("Test Name   : " + testName);
        System.out.println("Test Date   : " + testDate);
        System.out.println("Test Cost   : " + testCost);
        System.out.println("Test Result : " + testResult);
        // ASSOCIATION: Navigating relationship to get Patient's name
        System.out.println("Patient     : " + (patient != null ? patient.getFirstName() : "N/A"));
    }
}