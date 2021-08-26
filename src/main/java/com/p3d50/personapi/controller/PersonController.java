package com.p3d50.personapi.controller;

import com.p3d50.personapi.dto.request.PersonDTO;
import com.p3d50.personapi.dto.response.MessageResponseDTO;
import com.p3d50.personapi.exception.PersonNotFoundException;
import com.p3d50.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){

        this.personService=personService;
    }
    @GetMapping
    public List<PersonDTO> listAll(){

        return personService.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO postPersons(@RequestBody @Valid  PersonDTO person){
        return personService.createPerson(person);
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}
