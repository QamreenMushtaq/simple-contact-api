package com.example.simple_contactapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simple_contactapi.dto.ApiResponse;
import com.example.simple_contactapi.model.Contact;
import com.example.simple_contactapi.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;
    
    @GetMapping("/greet")
    public String hello(){
        return "Hello world: this is contact api";
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Contact>>> getAllContacts(){
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Contact>> createContact(@RequestBody Contact contact){
        return ResponseEntity.ok(contactService.addContact(contact));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable int id){
        return ResponseEntity.ok(contactService.deleteContact(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Contact>> updateContact(@PathVariable int id, @RequestBody Contact contactData){
        ApiResponse<Contact> response = contactService.updateContact(id, contactData);

        return ResponseEntity.ok(response);

    }

}
