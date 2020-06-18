package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.VehicleMaintenance;
import com.monikamisiewicz.fleet.repositories.VehicleMaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleMaintenanceService {

    private final VehicleMaintenanceRepository vehicleMaintenanceRepository;

    //Return list of vehicleMaintenances
    public List<VehicleMaintenance> getVehicleMaintenances(){
        return vehicleMaintenanceRepository.findAll();
    }

    //SAve new vehicleMaintenance
    public void save(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    //get by id
    public Optional<VehicleMaintenance> findById(int id) {
        return vehicleMaintenanceRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleMaintenanceRepository.deleteById(id);
    }
}
