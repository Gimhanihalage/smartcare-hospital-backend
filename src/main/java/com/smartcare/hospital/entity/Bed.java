package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "bed")
public class Bed {

    @Id
    @NotBlank(message = "Bed number is required")
    @Size(max = 10, message = "Bed number cannot exceed 10 characters")
    @Column(name = "bed_number")
    private String bedNumber;

    @NotBlank(message = "Bed status is required")
    @Pattern(regexp = "AVAILABLE|OCCUPIED", message = "Bed status must be AVAILABLE or OCCUPIED")
    @Column(name = "bed_status")
    private String bedStatus;

    @NotNull(message = "Room is required")
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