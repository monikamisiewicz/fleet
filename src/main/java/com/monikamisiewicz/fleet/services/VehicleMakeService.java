package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.VehicleMake;
import com.monikamisiewicz.fleet.repositories.VehicleMakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleMakeService {

    private final VehicleMakeRepository vehicleMakeRepository;

    public List<VehicleMake> getVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    public void save(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

    public Optional<VehicleMake> findById(int id) {
        return vehicleMakeRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }
}
