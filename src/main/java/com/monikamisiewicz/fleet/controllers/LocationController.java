package com.monikamisiewicz.fleet.controllers;

import com.monikamisiewicz.fleet.models.Country;
import com.monikamisiewicz.fleet.models.Location;
import com.monikamisiewicz.fleet.models.State;
import com.monikamisiewicz.fleet.services.CountryService;
import com.monikamisiewicz.fleet.services.LocationService;
import com.monikamisiewicz.fleet.services.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    private final CountryService countryService;
    private final StateService stateService;

    @GetMapping("/locations")
    public String getStates(Model model) {

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);

        return "location";
    }


    @PostMapping("/locations/addNew")
    public String addNew(Location location) {
        locationService.save(location);
        return "redirect:/locations ";
    }

    @RequestMapping("locations/findById")
    @ResponseBody
    public Optional<Location> findById(int id) {
        return locationService.findById(id);

    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location) {
        locationService.save(location);
        return "redirect:/locations ";
    }

    @RequestMapping(value = "/locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        locationService.delete(id);
        return "redirect:/locations ";
    }

}
