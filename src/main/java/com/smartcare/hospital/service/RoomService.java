package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Room;
import com.smartcare.hospital.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    // Room's primary key is the bed number itself (e.g. "B-101"), not a generated id
    public Room getById(String bedNumber) {
        return roomRepository.findById(bedNumber)
                .orElseThrow(() -> new RuntimeException("Room not found with bed number: " + bedNumber));
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }
}
