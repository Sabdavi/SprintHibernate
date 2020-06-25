package com.saeid.dao;

import com.saeid.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;


public interface PersonDao {

    public void save(Person p);

    public List<Person> list();
}
