package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.Invoice;
import com.monikamisiewicz.fleet.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public Optional<Invoice> findById(int id) {
        return invoiceRepository.findById(id);
    }

    public void delete(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
