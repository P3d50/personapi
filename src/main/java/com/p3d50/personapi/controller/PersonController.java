package com.p3d50.personapi.controller;

import com.p3d50.personapi.dto.MessageResponseDTO;
import com.p3d50.personapi.entity.Person;
import com.p3d50.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepo;

    @Autowired
    public PersonController(PersonRepository personRepo){
        this.personRepo=personRepo;
    }

    @GetMapping
    public MessageResponseDTO getPersons(){
        return MessageResponseDTO
                .builder()
                .message("Getting all persons\n"+this.personRepo.findAll().toString())
                .build();
    }

    @PostMapping
    public MessageResponseDTO postPersons(@RequestBody Person person){
        Person savedPerson = personRepo.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with id:"+savedPerson.getId())
                .build();
    }
}
