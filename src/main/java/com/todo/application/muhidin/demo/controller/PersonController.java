package com.todo.application.muhidin.demo.controller;


import com.todo.application.muhidin.demo.entity.Person;
import com.todo.application.muhidin.demo.service.InterfacePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private InterfacePersonService personService;

    @GetMapping("person/{id}")
    public ResponseEntity<Person> getPersonById( @PathVariable("id") int id){
        Person person = personService.getPersonById(id);

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("all-persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }


    @PostMapping("person")
    public ResponseEntity<Boolean> addPerson(@RequestBody Person person, UriComponentsBuilder builder) {
        boolean flag = personService.addPerson(person);
        if (!flag) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(builder.path("/person/{id}").buildAndExpand(person.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
