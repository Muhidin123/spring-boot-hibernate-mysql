package com.todo.application.muhidin.demo.dao;

import com.todo.application.muhidin.demo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository

public class PersonDAO implements InterfacePersonDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons() {
        String hql = "FROM Person as prsn ORDER BY prsn.name";
        return (List<Person>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addPerson(Person person) {
        entityManager.persist(person);
    }

    @Override
    public  Person getPersonById(int id){
        return entityManager.find(Person.class, id);
    }

    @Override
    public boolean personExists(String personName, String name) {
        String hql = "FROM Person as prsn WHERE prsn.name = ?";
        int count = entityManager.createQuery(hql).setParameter(1, name).getResultList().size();
        return count > 0;
    }

}
