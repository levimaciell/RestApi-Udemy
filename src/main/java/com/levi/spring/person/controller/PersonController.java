package com.levi.spring.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.levi.spring.person.dto.PersonDto;
import com.levi.spring.person.dto.PersonDtoV2;
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
    public PersonDto findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonDto> findAll(){
        return service.findAll();
    }

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDto create(@RequestBody PersonDto person){
        return service.create(person);
    }

    @PostMapping(
        value = "/v2",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDtoV2 createV2(@RequestBody PersonDtoV2 person){
        return service.createV2(person);
    }

    @PutMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDto update(@RequestBody PersonDto person){
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
