package com.monikamisiewicz.fleet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMaintenanceController {

    @GetMapping("/vehicleMaintenances")
    public String getVehicleMaintenances() {
        return "vehicleMaintenance";
    }
}
