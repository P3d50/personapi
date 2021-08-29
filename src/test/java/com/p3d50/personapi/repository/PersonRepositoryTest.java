package com.p3d50.personapi.repository;

import com.p3d50.personapi.entity.Person;
import com.p3d50.personapi.exception.PersonNotFoundException;
import com.p3d50.personapi.utils.PersonUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRespositoryUnderTest;

    @AfterEach
    void tearDown(){
        personRespositoryUnderTest.deleteAll();
    }

    //test PersonRepository.findById(Long id)
    @Test
    void itShoudCheckPersonThatExistsByCPF() throws PersonNotFoundException {
        //given
        Person createdPerson = personRespositoryUnderTest.save(PersonUtils.getDefaulTestPerson());

        //when
        Person returnedById = personRespositoryUnderTest.findByCPF(createdPerson.getCPF());

        //then
        assertThat(returnedById.getCPF()).isEqualTo(createdPerson.getCPF());
    }

    @Test
    void itShoudCheckPersonThatNotExistsByCPF() throws PersonNotFoundException {
        //given
        Person createdPerson = personRespositoryUnderTest.save(PersonUtils.getDefaulTestPerson());

        //when
        Person returnedById = personRespositoryUnderTest.findByCPF("111.111.111-11");

        //then
        assertThat(returnedById).isNull();
    }





}
