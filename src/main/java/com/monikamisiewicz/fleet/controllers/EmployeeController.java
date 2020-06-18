package com.monikamisiewicz.fleet.controllers;

import com.monikamisiewicz.fleet.models.Employee;
import com.monikamisiewicz.fleet.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final JobTitleService jobTitleService;
    private final EmployeeTypeService employeeTypeService;
    private final CountryService countryService;
    private final StateService stateService;


//    @GetMapping("/employees")
//    public String getEmployees(Model model, String keyword) {
//
//        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
//        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
//        model.addAttribute("countries", countryService.getCountries());
//        model.addAttribute("states", stateService.getStates());
//
//        if (keyword != null) {
//            model.addAttribute("employees", employeeService.findByKeyword(keyword));
//        } else {
//            model.addAttribute("employees", employeeService.getEmployees());
//        }
//
//        return "employee";
//    }
//
//    @GetMapping("/employeesFiltered")
//    public String getEmployeesFiltered(Model model, String keyword) {
//
//        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
//        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
//        model.addAttribute("countries", countryService.getCountries());
//        model.addAttribute("states", stateService.getStates());
//
//        model.addAttribute("employees", employeeService.getEmployees());
//
//
//        return "employeeFiltered";
//    }

    @GetMapping("/employees")
    public String getEmployees(Model model) {

        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());

        return "employee";
    }


    @PostMapping("/employees/addNew")
    public String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping("employees/findById")
    @ResponseBody
    public Optional<Employee> findById(int id) {
        return employeeService.findById(id);
    }

    @RequestMapping(value = "/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

}
