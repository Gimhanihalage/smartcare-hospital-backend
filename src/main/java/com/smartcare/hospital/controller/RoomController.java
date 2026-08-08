package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Room;
import com.smartcare.hospital.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAll());
    }

    // Room's id is the bed number itself, e.g. GET /api/rooms/B-101
    @GetMapping("/{bedNumber}")
    public ResponseEntity<Room> getRoomByBedNumber(@PathVariable String bedNumber) {
        return ResponseEntity.ok(roomService.getById(bedNumber));
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room saved = roomService.save(room);
        return ResponseEntity.ok(saved);
    }
}
