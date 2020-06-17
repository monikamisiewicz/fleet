package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.VehicleStatus;
import com.monikamisiewicz.fleet.repositories.VehicleStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleStatusService {

    private final VehicleStatusRepository vehicleStatusRepository;

    public List<VehicleStatus> getVehicleStatuses() {
        return vehicleStatusRepository.findAll();
    }

    public void save(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    public Optional<VehicleStatus> findById(int id) {
        return vehicleStatusRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }
}
