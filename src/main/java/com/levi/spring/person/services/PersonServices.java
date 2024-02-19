package com.levi.spring.person.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.levi.spring.person.entity.Person;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Finding one person...");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Juju");
        person.setLastName("Wesker");
        person.setAddress("Xique-Xique - Bahia - Brasil");
        person.setGender("Male");

        return person;
    }
}
