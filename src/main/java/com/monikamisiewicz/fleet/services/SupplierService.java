package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.Supplier;
import com.monikamisiewicz.fleet.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public Optional<Supplier> findById(int id) {
        return supplierRepository.findById(id);
    }

    public void delete(Integer id) {
        supplierRepository.deleteById(id);
    }
}
