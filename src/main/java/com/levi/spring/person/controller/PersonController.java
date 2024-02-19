package com.levi.spring.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.levi.spring.person.entity.Person;
import com.levi.spring.person.services.PersonServices;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(
        value = "/{id}", 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable(value = "id") String id){
        return service.findById(id);
    }

}
