package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.VehicleHire;
import com.monikamisiewicz.fleet.repositories.VehicleHireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleHireService {

    private final VehicleHireRepository vehicleHireRepository;

    //Return list of Vehicle Hire
    public List<VehicleHire> getVehicleHires(){
        return vehicleHireRepository.findAll();
    }

    //SAve new VehicleHire
    public void save(VehicleHire vehicleHire) {
        vehicleHireRepository.save(vehicleHire);
    }

    //get by id
    public Optional<VehicleHire> findById(int id) {
        return vehicleHireRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleHireRepository.deleteById(id);
    }

}
