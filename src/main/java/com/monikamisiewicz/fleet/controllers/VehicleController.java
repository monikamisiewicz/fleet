package com.monikamisiewicz.fleet.controllers;

import com.monikamisiewicz.fleet.models.Vehicle;
import com.monikamisiewicz.fleet.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;
    private final LocationService locationService;
    	private final EmployeeService employeeService;
    	private final VehicleMakeService vehicleMakeService;
    	private final VehicleStatusService vehicleStatusService;
    	private final VehicleTypeService vehicleTypeService;
    	private final VehicleModelService vehicleModelService;


    @GetMapping("/vehicles")
    public String getVehicles(Model model) {

        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
        model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuses());
        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
        model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
        return "vehicle";
    }

    @PostMapping("/vehicles/addNew")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping("vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(int id) {
        return vehicleService.findById(id);
    }

    @RequestMapping(value="/vehicles/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value="/vehicles/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }
}
