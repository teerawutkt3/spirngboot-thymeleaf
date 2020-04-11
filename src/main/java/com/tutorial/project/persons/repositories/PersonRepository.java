package com.tutorial.project.persons.repositories;

import com.tutorial.project.persons.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
