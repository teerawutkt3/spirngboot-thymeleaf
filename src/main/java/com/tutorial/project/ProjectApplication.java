package com.tutorial.project;

import com.tutorial.project.persons.entities.Person;
import com.tutorial.project.persons.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProjectApplication {

    private final PersonRepository personRepository;

    public ProjectApplication(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Bean
    public FilterRegistrationBean<CharacterEncodingFilter> filterRegistrationBean() {
        FilterRegistrationBean<CharacterEncodingFilter> registrationBean = new FilterRegistrationBean<>();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding(StandardCharsets.UTF_8.name());
        registrationBean.setFilter(characterEncodingFilter);
        return registrationBean;
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            personRepository.saveAll(getPersonList());

        };
    }

    private List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Person person = new Person();
            person.setName("Top" + i);
            person.setLast("Tee" + i);
            person.setAge(25 + i);
            person.setCity("Tak" + i);
			personList.add(person);
        }
        return personList;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

}
