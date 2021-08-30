package com.p3d50.personapi.controller;

import com.p3d50.personapi.dto.request.PersonDTO;
import com.p3d50.personapi.dto.response.MessageResponseDTO;
import com.p3d50.personapi.exception.PersonNotFoundException;
import com.p3d50.personapi.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@Api(value="Person REST API")
@CrossOrigin(origins = "*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @GetMapping
    @ApiOperation(value="Returns all Persons")
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @PostMapping
    @ApiOperation(value="Create a Person")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO postPersons(@RequestBody @Valid  PersonDTO person){
        return personService.createPerson(person);
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Returns a Person by ID")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }


    @GetMapping("/cpf")
    @ApiOperation(value="Returns a person by CPF")
    public PersonDTO findByCPF(@RequestParam(required = true) String num) throws PersonNotFoundException {
        return personService.findByCPF(num);
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Update a person by Id")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id,personDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Delete a person by ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}
