package com.monikamisiewicz.fleet.controllers;

import com.monikamisiewicz.fleet.models.Client;
import com.monikamisiewicz.fleet.models.Invoice;
import com.monikamisiewicz.fleet.models.InvoiceStatus;
import com.monikamisiewicz.fleet.services.ClientService;
import com.monikamisiewicz.fleet.services.InvoiceService;
import com.monikamisiewicz.fleet.services.InvoiceStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class InvoiceController {


    private final InvoiceService invoiceService;
    private final InvoiceStatusService invoiceStatusService;
    private final ClientService clientService;

    @GetMapping("/invoices")
    public String getInvoices(Model model) {

        List<Invoice> invoiceList = invoiceService.getInvoices();
        model.addAttribute("invoices", invoiceList);

        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
        model.addAttribute("invoiceStatuses", invoiceStatusList);

        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);

        return "invoice";
    }

    @PostMapping("/invoices/addNew")
    public String addNew(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices ";
    }

    @RequestMapping("invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(int id) {
        return  invoiceService.findById(id);

    }

    @RequestMapping(value = "/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices ";
    }

    @RequestMapping(value = "/invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        invoiceService.delete(id);
        return "redirect:/invoices ";
    }

}
