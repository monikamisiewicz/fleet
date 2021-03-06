package com.monikamisiewicz.fleet.repositories;

import com.monikamisiewicz.fleet.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer > {
}
