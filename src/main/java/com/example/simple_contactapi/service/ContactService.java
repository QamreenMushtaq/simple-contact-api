package com.example.simple_contactapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simple_contactapi.dto.ApiResponse;
import com.example.simple_contactapi.model.Contact;
import com.example.simple_contactapi.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ApiResponse<List<Contact>> getAllContacts(){
        List<Contact> contactList = contactRepository.findAll();
        return new ApiResponse<>(200,"all list here",contactList);
    }

    public ApiResponse<Contact> addContact(Contact contact){
        Contact savedContact = contactRepository.save(contact);
        return new ApiResponse<>(201,"Contact added successfully",savedContact);
    }

     public ApiResponse<?> deleteContact(int id){
        if(contactRepository.findById(id).isPresent()){
            contactRepository.deleteById(id);
            return new ApiResponse<>(204, "Contact Deleted Successfully", null);
        }
        return new ApiResponse<>(404, "Contact Not Found", null);
    }


    public ApiResponse<Contact> updateContact(int id, Contact updatedData){
        return contactRepository.findById(id)
               .map(existingContact -> {
                     existingContact.setName(updatedData.getName());
                     existingContact.setPhoneNumber(updatedData.getPhoneNumber());
                     contactRepository.save(existingContact);
                     return new ApiResponse<>(200,"Contact updated successfully",existingContact);
               })

               .orElse(new ApiResponse<>(404,"Contact not found",null));
     }
                    
               
        

    
}
