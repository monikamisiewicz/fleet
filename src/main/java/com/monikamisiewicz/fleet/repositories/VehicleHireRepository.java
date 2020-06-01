package com.monikamisiewicz.fleet.repositories;

import com.monikamisiewicz.fleet.models.VehicleHire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleHireRepository extends JpaRepository<VehicleHire, Integer> {
}
