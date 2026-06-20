package com.example.simple_contactapi.model;

public class Contact {
    
    private Integer id;
    private String name;
    private String phoneNumber;


    //will use lombok ahead to generate getters and setters, constructor
    public Contact() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}
