package com.levi.spring.person.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.levi.spring.person.entity.Person;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){

        logger.info("Finding all people");
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }


        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person Name:" + i);
        person.setLastName("Last Name:" + i);
        person.setAddress("Brasil");
        person.setGender("Male");
        return person;
    }

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
