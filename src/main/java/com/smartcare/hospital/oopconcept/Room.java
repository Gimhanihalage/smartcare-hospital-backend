// File: oopconcept/Room.java
package com.smartcare.hospital.oopconcept;

import java.util.ArrayList;
import java.util.List;

public class Room {
    // ENCAPSULATION: Private fields with controlled access
    private String roomNumber;
    private String roomType;
    private double roomChargePerDay;

    // ASSOCIATION: Room "has-a" list of Beds (Composition - Beds are strongly owned by Room)
    private List<Bed> beds = new ArrayList<>();

    // ENCAPSULATION: Constructor initializes private fields
    public Room(String roomNumber, String roomType, double roomChargePerDay) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomChargePerDay = roomChargePerDay;
    }

    // ENCAPSULATION: Getter for private field 'roomNumber'
    public String getRoomNumber() {
        return roomNumber;
    }

    // ENCAPSULATION: Setter for private field 'roomNumber'
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    // ENCAPSULATION: Getter for private field 'roomType'
    public String getRoomType() {
        return roomType;
    }

    // ENCAPSULATION: Setter for private field 'roomType'
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    // ENCAPSULATION: Getter for private field 'roomChargePerDay'
    public double getRoomChargePerDay() {
        return roomChargePerDay;
    }

    // ENCAPSULATION: Setter for private field 'roomChargePerDay'
    public void setRoomChargePerDay(double roomChargePerDay) {
        this.roomChargePerDay = roomChargePerDay;
    }

    // ASSOCIATION: Getter exposing the composed list of Beds
    public List<Bed> getBeds() {
        return beds;
    }

    // ASSOCIATION (COMPOSITION): Adds a Bed into this Room's internal collection
    public void addBed(Bed bed) {
        this.beds.add(bed);
    }

    public void displayRoom() {
        System.out.println("---- Room Details ----");
        System.out.println("Room Number     : " + roomNumber);
        System.out.println("Room Type       : " + roomType);
        System.out.println("Charge Per Day  : " + roomChargePerDay);
        System.out.println("Beds in Room    : " + beds.size());
        // ASSOCIATION: Iterating over composed Bed objects
        for (Bed b : beds) {
            b.displayBed();
        }
    }
}