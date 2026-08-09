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
    public List<Bed> getAllBeds() {
        return bedService.getAllBeds();
    }

    @GetMapping("/{id}")
    public Bed getBedById(@PathVariable Long id) {
        return bedService.getBedById(id);
    }

    @PutMapping("/{id}")
    public Bed updateBed(@PathVariable Long id, @RequestBody Bed bed) {
        return bedService.updateBed(id, bed);
    }

    @DeleteMapping("/{id}")
    public void deleteBed(@PathVariable Long id) {
        bedService.deleteBed(id);
    }
}