package com.smartcare.hospital.ResourceNotFoundException.java;

public class InvalidPatientDataException extends RuntimeException {
    public InvalidPatientDataException(String message) {
        super(message);
    }
}