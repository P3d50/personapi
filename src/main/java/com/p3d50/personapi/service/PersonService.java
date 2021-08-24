package com.p3d50.personapi.service;

import com.p3d50.personapi.dto.MessageResponseDTO;
import com.p3d50.personapi.entity.Person;
import com.p3d50.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepo;

    @Autowired
    public PersonService(PersonRepository personRepo){
        this.personRepo=personRepo;
    }


    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepo.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with id:" + savedPerson.getId())
                .build();
    }

    public MessageResponseDTO findAll(){
        return MessageResponseDTO
                .builder()
                .message("Getting all persons\n"+this.personRepo.findAll().toString())
                .build();
    }
}
