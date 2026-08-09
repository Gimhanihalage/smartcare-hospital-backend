package com.smartcare.hospital.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @Column(name = "Room_Id", length = 20)
    private Integer roomId;

    @Column(name = "Availability_Status", length = 20)
    private String availabilityStatus;

    @Column(name = "Room_Category", length = 50)
    private String roomCategory;

    public Room() {
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }
}