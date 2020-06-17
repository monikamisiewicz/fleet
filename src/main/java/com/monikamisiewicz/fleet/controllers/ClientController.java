package com.monikamisiewicz.fleet.controllers;

import com.monikamisiewicz.fleet.models.Client;
import com.monikamisiewicz.fleet.models.Country;
import com.monikamisiewicz.fleet.models.State;
import com.monikamisiewicz.fleet.services.ClientService;
import com.monikamisiewicz.fleet.services.CountryService;
import com.monikamisiewicz.fleet.services.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final CountryService countryService;
    private final StateService stateService;

    @GetMapping("/clients")
    public String getClients(Model model) {

        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);
        return "client";
    }


    @PostMapping("/clients/addNew")
    public String addNew(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping("clients/findById")
    @ResponseBody
    public Optional<Client> findById(int id) {
        return  clientService.findById(id);

    }

    @RequestMapping(value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}
