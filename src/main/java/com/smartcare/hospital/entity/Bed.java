package com.smartcare.hospital.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bed")
public class Bed {

    @Id
    @Column(name = "bed_number")
    private String bedNumber;

    @Column(name = "bed_status")
    private String bedStatus; // AVAILABLE / OCCUPIED

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    // Encapsulation - getters & setters
    public String getBedNumber() { return bedNumber; }
    public void setBedNumber(String bedNumber) { this.bedNumber = bedNumber; }

    public String getBedStatus() { return bedStatus; }
    public void setBedStatus(String bedStatus) { this.bedStatus = bedStatus; }

    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
}
