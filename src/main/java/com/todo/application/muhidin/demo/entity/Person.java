package com.todo.application.muhidin.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    @GeneratedValue(strategy= GenerationType.AUTO)

    private int id;
    private String name;

    public Person() {
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }

    public String getName(){return name;}
    public void setName(String name){this.name = name;}
}
