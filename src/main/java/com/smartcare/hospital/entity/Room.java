package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @NotNull(message = "Room ID is required")
    @Column(name = "Room_Id", length = 20)
    private Integer roomId;

    @NotBlank(message = "Availability status is required")
    @Pattern(regexp = "AVAILABLE|OCCUPIED|MAINTENANCE", message = "Availability status must be AVAILABLE, OCCUPIED, or MAINTENANCE")
    @Column(name = "Availability_Status", length = 20)
    private String availabilityStatus;

    @NotBlank(message = "Room category is required")
    @Size(max = 50, message = "Room category cannot exceed 50 characters")
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