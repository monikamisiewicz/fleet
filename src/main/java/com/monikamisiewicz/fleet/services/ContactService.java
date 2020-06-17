package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.Contact;
import com.monikamisiewicz.fleet.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    //Return list of contacts
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    //SAve new contact
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    //get by id
    public Optional<Contact> findById(int id) {
        return contactRepository.findById(id);
    }

    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }
}
