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

    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable Integer roomId) {
        return ResponseEntity.ok(roomService.getById(roomId));
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room saved = roomService.save(room);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<Room> updateRoom(@PathVariable Integer roomId, @RequestBody Room room) {
        Room updated = roomService.update(roomId, room);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable Integer roomId) {
        roomService.delete(roomId);
        return ResponseEntity.ok("Room deleted successfully: " + roomId);
    }
}