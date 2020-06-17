package com.monikamisiewicz.fleet.controllers;

import com.monikamisiewicz.fleet.models.Contact;
import com.monikamisiewicz.fleet.services.ContactService;
import com.monikamisiewicz.fleet.services.CountryService;
import com.monikamisiewicz.fleet.services.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
    private final CountryService countryService;
    private final StateService stateService;

    @GetMapping("/contacts")
    public String getContacts(Model model) {
        model.addAttribute("contacts", contactService.getContacts());

        model.addAttribute("countries", countryService.getCountries());

        model.addAttribute("states", stateService.getStates());


        return "contacts";
    }

    @PostMapping("/contacts/addNew")
    public String addNew(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping("contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(int id) {
        return contactService.findById(id);
    }

    @RequestMapping(value="/contacts/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value="/contacts/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
