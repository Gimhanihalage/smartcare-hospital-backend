package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Bed;
import com.smartcare.hospital.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedService {

    @Autowired
    private BedRepository bedRepository;

    public Bed addBed(Bed bed) {
        return bedRepository.save(bed);
    }

    public List<Bed> getAllBeds() {
        return bedRepository.findAll();
    }

    public Bed getBedById(Long id) {
        return bedRepository.findById(id).orElse(null);
    }

    public Bed updateBed(Long id, Bed bedDetails) {
        Bed bed = bedRepository.findById(id).orElse(null);
        if (bed != null) {
            bed.setBedNumber(bedDetails.getBedNumber());
            return bedRepository.save(bed);
        }
        return null;
    }

    public void deleteBed(Long id) {
        bedRepository.deleteById(id);
    }
}