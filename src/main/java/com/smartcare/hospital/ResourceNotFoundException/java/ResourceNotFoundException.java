package com.smartcare.hospital.ResourceNotFoundException.java;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}