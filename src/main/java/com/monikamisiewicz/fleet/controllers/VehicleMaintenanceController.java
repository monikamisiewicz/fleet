package com.monikamisiewicz.fleet.controllers;

import com.monikamisiewicz.fleet.models.VehicleMaintenance;
import com.monikamisiewicz.fleet.services.SupplierService;
import com.monikamisiewicz.fleet.services.VehicleMaintenanceService;
import com.monikamisiewicz.fleet.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class VehicleMaintenanceController {

    private final VehicleMaintenanceService vehicleMaintenanceService;
    private final VehicleService vehicleService;
    private final SupplierService supplierService;


    @GetMapping("/vehicleMaintenances")
    public String getVehicleMaintenances(Model model) {

        model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintenances());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("suppliers", supplierService.getSuppliers());

        return "vehicleMaintenance";
    }

    @PostMapping("/vehicleMaintenances/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping("vehicleMaintenances/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(int id) {
        return vehicleMaintenanceService.findById(id);
    }

    @RequestMapping(value="/vehicleMaintenances/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping(value="/vehicleMaintenances/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicleMaintenances";
    }
}
