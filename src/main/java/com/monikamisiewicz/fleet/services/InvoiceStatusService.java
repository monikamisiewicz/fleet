package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.InvoiceStatus;
import com.monikamisiewicz.fleet.repositories.InvoiceStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceStatusService {

    private final InvoiceStatusRepository invoiceStatusRepository;

    public List<InvoiceStatus> getInvoiceStatuses() {
        return invoiceStatusRepository.findAll();
    }

    public void save(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    public Optional<InvoiceStatus> findById(int id) {
        return invoiceStatusRepository.findById(id);
    }

    public void delete(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }
}
