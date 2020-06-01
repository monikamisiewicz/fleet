package com.monikamisiewicz.fleet.repositories;

import com.monikamisiewicz.fleet.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
