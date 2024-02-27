package com.levi.spring.person.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levi.spring.exceptions.ResourceNotFoundException;
import com.levi.spring.person.dto.PersonDto;
import com.levi.spring.person.entity.Person;
import com.levi.spring.repositories.PersonRepository;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    public List<PersonDto> findAll(){

        logger.info("Finding all people");
        return repository.findAll().stream().map((x) -> new PersonDto(x.getId(), x.getFirstName(), x.getLastName(), x.getAddress(), x.getGender())).toList();
    }

    public PersonDto findById(Long id){
        logger.info("Finding one person...");
        Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id! "));
        return new PersonDto(person.getId(), person.getFirstName(), person.getLastName(), person.getAddress(), person.getGender());
    }

    public PersonDto create(PersonDto person) {
        logger.info("Creating one person...");

        Person entity = new Person(person.getId(), person.getFirstName(), person.getLastName(), person.getAddress(), person.getGender());
        repository.save(entity);

        return person;
    }

    public PersonDto update(PersonDto person) {
        logger.info("Updating one person...");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id! "));
        
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        repository.save(entity);

        return person;
    }

    public void delete(Long id) {
        logger.info("Deleting one person...");

        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id! "));

        repository.deleteById(id);
    }

    
}
