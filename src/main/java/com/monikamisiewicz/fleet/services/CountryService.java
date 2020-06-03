package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.Country;
import com.monikamisiewicz.fleet.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public void save(Country country) {
        countryRepository.save(country);
    }

    public Optional<Country> findById(int id) {
        return countryRepository.findById(id);
    }
}
