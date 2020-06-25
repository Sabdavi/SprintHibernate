package com.saeid.service;


import com.saeid.dao.PersonDao;
import com.saeid.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonDao personDao;

    @Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

     public List<Person> getPersons(){
        return personDao.list();
    }
}
