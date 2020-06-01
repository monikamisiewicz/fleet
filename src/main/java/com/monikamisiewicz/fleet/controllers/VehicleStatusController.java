package com.monikamisiewicz.fleet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleStatusController {

    @GetMapping("/vehicleStatuses")
    public String getVehicleStatuses() {
        return "vehicleStatus";
    }
}
