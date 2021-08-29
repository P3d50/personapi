package com.p3d50.personapi.service;

import com.p3d50.personapi.dto.response.MessageResponseDTO;
import com.p3d50.personapi.entity.Person;
import com.p3d50.personapi.exception.PersonNotFoundException;
import com.p3d50.personapi.mapper.PersonMapper;
import com.p3d50.personapi.repository.PersonRepository;
import com.p3d50.personapi.utils.PersonUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personServiceUnderTest;

    private final PersonMapper personMapper = PersonMapper.INSTANCE.INSTANCE;


    @BeforeEach
    void setUp() {
        personServiceUnderTest = new PersonService(personRepository);
    }


    @Test
    void canCreatePerson() {
        //given
        Person person = PersonUtils.getDefaulTestPerson();

        //when
        personServiceUnderTest.createPerson(personMapper.toDTO(person));

        //then
        ArgumentCaptor<Person> personArgumentCaptor = ArgumentCaptor.forClass(Person.class);
        verify(personRepository).save(personArgumentCaptor.capture());
        Person capturedPerson = personArgumentCaptor.getValue();
        assertThat(capturedPerson).isEqualTo(person);
    }

    @Test
    void canListAllPersons() {
        //when
        personServiceUnderTest.listAll();

        //then
        verify(personRepository).findAll();
    }


    @Test
    void itShouldNotfindPersonByCPFThatNotExists() {
        //given
        Person person = PersonUtils.getDefaulTestPerson();

        //when
        String cpf = "111.111.111-11";

        //then
        assertThatThrownBy(()->personServiceUnderTest.findByCPF(cpf))
                .isInstanceOf(PersonNotFoundException.class)
                .hasMessageContaining("CPF não encontrado: "+cpf);

    }
}