package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.VehicleType;
import com.monikamisiewicz.fleet.repositories.VehicleTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleTypeService {

    private final VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    public void save(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    public Optional<VehicleType> findById(int id) {
        return vehicleTypeRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }
}
