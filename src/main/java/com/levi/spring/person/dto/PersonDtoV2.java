package com.levi.spring.person.dto;

import java.util.Date;

public class PersonDtoV2 {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date Birthday;
    
    public PersonDtoV2(Long id, String firstName, String lastName, String address, String gender, Date Birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.Birthday = Birthday;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return Birthday;
    }

    
}
