package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.Vehicle;
import com.monikamisiewicz.fleet.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    //Return list of vehicles
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

    //SAve new vehicle
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    //get by id
    public Optional<Vehicle> findById(int id) {
        return vehicleRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
