package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.EmployeeType;
import com.monikamisiewicz.fleet.repositories.EmployeeTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeTypeService {

    private final EmployeeTypeRepository employeeTypeRepository;

    public List<EmployeeType> getEmployeeTypes() {
        return employeeTypeRepository.findAll();
    }

    public void save(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    public Optional<EmployeeType> findById(int id) {
        return employeeTypeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }
}
