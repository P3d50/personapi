package com.p3d50.personapi.controller;

import com.p3d50.personapi.dto.MessageResponseDTO;
import com.p3d50.personapi.entity.Person;
import com.p3d50.personapi.repository.PersonRepository;
import com.p3d50.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService=personService;
    }
    @GetMapping
    public String getPersons(){
        return personService.findAll().toString();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String postPersons(@RequestBody Person person){
        return personService.createPerson(person).toString();
    }
}
