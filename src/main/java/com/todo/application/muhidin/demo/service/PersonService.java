package com.todo.application.muhidin.demo.service;

import com.todo.application.muhidin.demo.dao.InterfacePersonDAO;
import com.todo.application.muhidin.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements InterfacePersonService{

    @Autowired
    private InterfacePersonDAO personDAO;

    @Override
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Override
    public Person getPersonById(int id) {
        return personDAO.getPersonById(id);
    }


    @Override
    public synchronized boolean addPerson(Person person){
        if(personDAO.personExists(person.getName(), person.getName())){
            return false;
        } else {
            personDAO.addPerson(person);
            return true;
        }
    }
}
