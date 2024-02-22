package com.levi.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levi.spring.person.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{}
