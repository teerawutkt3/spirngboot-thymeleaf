package com.tutorial.project.persons.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PERSONS")
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String last;
    private int age;
    private String city;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last='" + last + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
