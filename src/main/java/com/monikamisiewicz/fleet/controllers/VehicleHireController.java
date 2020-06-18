package com.monikamisiewicz.fleet.controllers;

import com.monikamisiewicz.fleet.models.VehicleHire;
import com.monikamisiewicz.fleet.services.ClientService;
import com.monikamisiewicz.fleet.services.LocationService;
import com.monikamisiewicz.fleet.services.VehicleHireService;
import com.monikamisiewicz.fleet.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class VehicleHireController {

    private final VehicleHireService vehicleHireService;
    private final VehicleService vehicleService;
    private final LocationService locationService;
    private final ClientService clientService;


    @GetMapping("/vehicleHires")
    public String getVehicleHires(Model model) {

        model.addAttribute("vehicleHires", vehicleHireService.getVehicleHires());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("clients", clientService.getClients());

        return "vehicleHire";
    }

    @PostMapping("/vehicleHires/addNew")
    public String addNew(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping("vehicleHires/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(int id) {
        return vehicleHireService.findById(id);
    }

    @RequestMapping(value = "/vehicleHires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping(value = "/vehicleHires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/vehicleHires";
    }
}
