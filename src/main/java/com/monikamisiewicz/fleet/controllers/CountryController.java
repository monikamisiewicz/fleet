package com.monikamisiewicz.fleet.controllers;

import com.monikamisiewicz.fleet.models.Country;
import com.monikamisiewicz.fleet.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/countries")
    public String getCountries(Model model) {

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);
        return "country";
    }

}
