package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.VehicleMovement;
import com.monikamisiewicz.fleet.repositories.VehicleMovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleMovementService {

    private final VehicleMovementRepository vehicleMovementRepository;

    //Return list of vehicleMovements
    public List<VehicleMovement> getVehicleMovements(){
        return vehicleMovementRepository.findAll();
    }

    //SAve new vehicleMovement
    public void save(VehicleMovement vehicleMovement) {
        vehicleMovementRepository.save(vehicleMovement);
    }

    //get by id
    public Optional<VehicleMovement> findById(int id) {
        return vehicleMovementRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleMovementRepository.deleteById(id);
    }

}
