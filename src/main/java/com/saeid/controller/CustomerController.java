package com.saeid.controller;

import com.saeid.model.Person;
import com.saeid.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    final PersonService personService;

    public CustomerController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getCustomerById(){
        List<Person> persons = personService.getPersons();
        return new ResponseEntity<List<Person>>(persons, HttpStatus.ACCEPTED);
    }
    @GetMapping("/person1")
    public ResponseEntity<Person> getCustomerById1(){
        Person person= new Person();
        person.setCountry("IRAN");
        return new ResponseEntity<Person>(person, HttpStatus.ACCEPTED);
    }
}
