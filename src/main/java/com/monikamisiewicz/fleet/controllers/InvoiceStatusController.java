package com.monikamisiewicz.fleet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceStatusController {

    @GetMapping("/invoiceStatuses")
    public String getInvoiceStatuses() {
        return "invoiceStatus";
    }
}
