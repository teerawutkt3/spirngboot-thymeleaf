package com.tutorial.project.persons.services;

import com.tutorial.project.persons.entities.Person;
import com.tutorial.project.persons.repositories.PersonRepo;
import com.tutorial.project.persons.repositories.PersonRepository;
import com.tutorial.project.persons.vo.PersonCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonRepo personRepo;
    public List<Person> findAll() {
        PersonCriteria criteria = PersonCriteria.builder().build();
        criteria.setName("top");
        List<Person>  rs = personRepo.searchPerson(criteria);
        return rs;
    }

    public Person findById(long id) {
        return personRepository.findById(id).get();
    }

    @Transactional(rollbackOn = Exception.class)
    public void delete(long id){
        personRepository.deleteById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public void save(Person person) {
        personRepository.save(person);
    }
}
