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

    public Room getById(Integer roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public Room update(Integer roomId, Room room) {
        Room existing = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));

        existing.setRoomCategory(room.getRoomCategory());
        existing.setAvailabilityStatus(room.getAvailabilityStatus());

        return roomRepository.save(existing);
    }

    public void delete(Integer roomId) {
        if (!roomRepository.existsById(roomId)) {
            throw new RuntimeException("Room not found with id: " + roomId);
        }
        roomRepository.deleteById(roomId);
    }
}