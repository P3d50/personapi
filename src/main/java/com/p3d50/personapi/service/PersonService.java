package com.p3d50.personapi.service;

import com.p3d50.personapi.dto.request.PersonDTO;
import com.p3d50.personapi.dto.response.MessageResponseDTO;
import com.p3d50.personapi.entity.Person;
import com.p3d50.personapi.exception.PersonNotFoundException;
import com.p3d50.personapi.mapper.PersonMapper;
import com.p3d50.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToCreate = personMapper.toModel(personDTO);

        Person createdPerson = personRepository.save(personToCreate);
        return MessageResponseDTO.builder()
                .message((createdPerson!=null)?"Created person with id: "+createdPerson.getId():"Person null")
                .build();
    }

    public List<PersonDTO> listAll() {

        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());

    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        return personMapper.toDTO(personRepository.findById(id).get());
    }

    public PersonDTO findByCPF(String cpf) throws PersonNotFoundException {
        Person person = personRepository.findByCPF(cpf);
        if((person!=null)&&person.getCPF().equals(cpf)) {
            return personMapper.toDTO(person);
        }else{
            throw new PersonNotFoundException("CPF não encontrado: "+cpf);
        }
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated person with id:");
    }

    private void verifyIfExists(Long id) throws PersonNotFoundException {
        personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }


}
