package com.example.simple_contactapi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.simple_contactapi.model.Contact;

@Repository
public class ContactRepository {

    //in memory 
    private final List<Contact> contactList = new ArrayList<>();
    private int idCounter = 1;


    public List<Contact> findAll(){
        return new ArrayList<>(contactList);
    }



    public Optional<Contact> findById(int id){
        return contactList.stream()
                    .filter(contact ->contact.getId() == id)
                    .findFirst();

    }



    public Contact save(Contact contact){
        if(contact.getId() == null || contact.getId() <= 0){
            contact.setId(idCounter++);
            contactList.add(contact);
        }
        else{
            deleteById(contact.getId());
            contactList.add(contact);
        }
        return contact;
    }




    public void deleteById(int id){
        contactList.removeIf(contact -> contact.getId() == id);
    }

}
