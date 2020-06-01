package com.monikamisiewicz.fleet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeTypeController {

    @GetMapping("/employeeTypes")
    public String getEmployeeTypes() {
        return "employeeType";
    }
}
