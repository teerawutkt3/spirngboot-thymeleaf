package com.tutorial.project.persons.controllers;

import com.tutorial.project.persons.entities.Person;
import com.tutorial.project.persons.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/person/index.html");
        List<Person> personList = personService.findAll();
        mav.addObject("personList", personList);
        System.out.println("personList : " + personList.size());
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView crete() {
        ModelAndView mav = new ModelAndView("/person/create.html");
        mav.addObject("person", new Person());
        return mav;
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("/person/update.html");
        mav.addObject("person", personService.findById(id));
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        personService.delete(id);
        return "redirect:/person/";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Person person) {
        try {
            personService.save(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/person/";
    }

    private void setForm(ModelAndView mav, Person person) {
        mav.addObject("person", person);
        mav.addObject("personList", personService.findAll());
    }

}
