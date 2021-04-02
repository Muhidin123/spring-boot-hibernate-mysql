package com.todo.application.muhidin.demo.dao;

import com.todo.application.muhidin.demo.entity.Person;

import java.util.List;

public interface InterfacePersonDAO {
    List<Person> getAllPersons();
    void addPerson(Person person);
    Person getPersonById(int id);
    boolean personExists(String personName, String name);
}
