package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> { // <-- මෙතන String තිබුනා නම් Long කරන්න
}


