package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Bed;
import com.smartcare.hospital.ResourceNotFoundException.java.ResourceNotFoundException;
import com.smartcare.hospital.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedRepository bedRepository;

    @Override
    public Bed addBed(Bed bed) {
        return bedRepository.save(bed);
    }

    @Override
    public Bed updateBed(String bedNumber, Bed bed) {
        Bed existingBed = bedRepository.findById(bedNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Bed not found with number: " + bedNumber));

        existingBed.setBedStatus(bed.getBedStatus());
        existingBed.setRoom(bed.getRoom());
        return bedRepository.save(existingBed);
    }

    @Override
    public void deleteBed(String bedNumber) {
        if (!bedRepository.existsById(bedNumber)) {
            throw new ResourceNotFoundException("Bed not found with number: " + bedNumber);
        }
        bedRepository.deleteById(bedNumber);
    }

    @Override
    public Bed getBedByNumber(String bedNumber) {
        return bedRepository.findById(bedNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Bed not found with number: " + bedNumber));
    }

    @Override
    public List<Bed> getAllBeds() {
        return bedRepository.findAll();
    }

    @Override
    public List<Bed> getBedsByRoom(Integer roomId) {
        return bedRepository.findByRoom_RoomId(roomId);
    }

    @Override
    public List<Bed> getAvailableBeds() {
        return bedRepository.findByBedStatus("Available");
    }
}