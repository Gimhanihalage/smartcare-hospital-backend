package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Bed;
import java.util.List;

public interface BedService {
    Bed addBed(Bed bed);
    Bed updateBed(String bedNumber, Bed bed);
    void deleteBed(String bedNumber);
    Bed getBedByNumber(String bedNumber);
    List<Bed> getAllBeds();
    List<Bed> getBedsByRoom(Integer roomId);
    List<Bed> getAvailableBeds();
}