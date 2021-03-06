package com.monikamisiewicz.fleet.controllers;

import com.monikamisiewicz.fleet.models.VehicleMovement;
import com.monikamisiewicz.fleet.services.LocationService;
import com.monikamisiewicz.fleet.services.VehicleMovementService;
import com.monikamisiewicz.fleet.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class VehicleMovementController {

    private final VehicleMovementService vehicleMovementService;
    private final VehicleService vehicleService;
    private final LocationService locationService;


    @GetMapping("/vehicleMovements")
    public String getVehicleMovements(Model model) {
        model.addAttribute("vehicleMovements", vehicleMovementService.getVehicleMovements());

        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("locations", locationService.getLocations());


        return "vehicleMovement";
    }

    @PostMapping("/vehicleMovements/addNew")
    public String addNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping("vehicleMovements/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(int id) {
        return vehicleMovementService.findById(id);
    }

    @RequestMapping(value = "/vehicleMovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value = "/vehicleMovements/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovements";
    }

}
