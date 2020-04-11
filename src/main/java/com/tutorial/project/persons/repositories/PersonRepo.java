package com.tutorial.project.persons.repositories;

import com.tutorial.project.persons.entities.Person;
import com.tutorial.project.persons.vo.PersonCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepo {
    @PersistenceContext
    EntityManager em;

    public List<Person> searchPerson(PersonCriteria criteria) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);

        Root<Person> person = cq.from(Person.class);
        List<Predicate> paramsPredicate = new ArrayList<>();
        if (!StringUtils.isEmpty(criteria.getName())) paramsPredicate.add(cb.equal(person.get("name"), criteria.getName()));
        if (!StringUtils.isEmpty(criteria.getLast())) paramsPredicate.add(cb.like(person.get("last"), "%" + criteria.getLast() + "%"));
//        Predicate namePredicate = cb.equal(person.get("name"), criteria.getName());
//        Predicate lastPredicate = cb.like(person.get("last"), "%" + last + "%");
        cq.where(paramsPredicate.toArray(new Predicate[0]));

        TypedQuery<Person> query = em.createQuery(cq);
        return query.getResultList();
    }
}
