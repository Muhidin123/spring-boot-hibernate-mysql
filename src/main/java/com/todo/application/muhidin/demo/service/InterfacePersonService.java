package com.todo.application.muhidin.demo.service;

import com.todo.application.muhidin.demo.entity.Person;

import java.util.List;

public interface InterfacePersonService {
    List<Person> getAllPersons();
    Person getPersonById(int id);
    boolean addPerson(Person person);

}
