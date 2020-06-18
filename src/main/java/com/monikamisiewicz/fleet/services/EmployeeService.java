package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.Employee;
import com.monikamisiewicz.fleet.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    //Return list of employees
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    //SAve new employee
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    //get by id
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    //Get employees by keyword
    public List<Employee> findByKeyword(String keyword){
        return employeeRepository.findByKeyword(keyword);

    }

}
