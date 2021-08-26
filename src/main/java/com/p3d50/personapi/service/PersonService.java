package com.p3d50.personapi.service;

import com.p3d50.personapi.dto.request.PersonDTO;
import com.p3d50.personapi.dto.response.MessageResponseDTO;
import com.p3d50.personapi.entity.Person;
import com.p3d50.personapi.mapper.PersonMapper;
import com.p3d50.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository=personRepository;
    }


    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with id:" + savedPerson.getId())
                .build();
    }

    public MessageResponseDTO findAll(){
        return MessageResponseDTO
                .builder()
                .message("Getting all persons\n"+this.personRepository.findAll().toString())
                .build();
    }

    public List<PersonDTO> listAll() {

        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());

    }
}
