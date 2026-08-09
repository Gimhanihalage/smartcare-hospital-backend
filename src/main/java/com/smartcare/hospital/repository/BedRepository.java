package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BedRepository extends JpaRepository<Bed, String> {


    List<Bed> findByRoom_RoomId(Integer roomId);
    List<Bed> findByBedStatus(String bedStatus);
}
