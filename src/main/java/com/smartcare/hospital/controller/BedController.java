package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Bed;
import com.smartcare.hospital.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beds")
public class BedController {

    @Autowired
    private BedService bedService;

    @PostMapping
    public Bed addBed(@RequestBody Bed bed) {
        return bedService.addBed(bed);
    }

    @GetMapping
    public List<Bed> getAll() {
        return bedService.getAllBeds();
    }

    @GetMapping("/{bedNumber}")
    public Bed getByNumber(@PathVariable String bedNumber) {
        return bedService.getBedByNumber(bedNumber);
    }

    @PutMapping("/{bedNumber}")
    public Bed update(@PathVariable String bedNumber, @RequestBody Bed bed) {
        return bedService.updateBed(bedNumber, bed);
    }

    @DeleteMapping("/{bedNumber}")
    public void delete(@PathVariable String bedNumber) {
        bedService.deleteBed(bedNumber);
    }

    @GetMapping("/room/{roomId}")
    public List<Bed> getByRoom(@PathVariable Integer  roomId) {
        return bedService.getBedsByRoom(roomId);
    }

    @GetMapping("/available")
    public List<Bed> getAvailable() {
        return bedService.getAvailableBeds();
    }
}
