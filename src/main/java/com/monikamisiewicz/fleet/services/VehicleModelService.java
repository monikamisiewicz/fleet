package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.VehicleModel;
import com.monikamisiewicz.fleet.repositories.VehicleModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleModelService {

    private final VehicleModelRepository vehicleModelRepository;

    public List<VehicleModel> getVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    public void save(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    public Optional<VehicleModel> findById(int id) {
        return vehicleModelRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleModelRepository.deleteById(id);
    }
}
