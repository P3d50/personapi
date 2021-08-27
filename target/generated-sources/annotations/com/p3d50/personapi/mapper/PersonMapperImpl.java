package com.p3d50.personapi.mapper;

import com.p3d50.personapi.dto.request.PersonDTO;
import com.p3d50.personapi.entity.Person;
import com.p3d50.personapi.entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-27T08:12:31-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        person.setBirthDate( personDTO.getBirthDate() );
        person.setId( personDTO.getId() );
        person.setLastName( personDTO.getLastName() );
        person.setFirstName( personDTO.getFirstName() );
        person.setCpf( personDTO.getCpf() );
        List<Phone> list = personDTO.getPhones();
        if ( list != null ) {
            person.setPhones( new ArrayList<Phone>( list ) );
        }

        return person;
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( person.getId() );
        personDTO.setLastName( person.getLastName() );
        personDTO.setFirstName( person.getFirstName() );
        personDTO.setCpf( person.getCpf() );
        personDTO.setBirthDate( person.getBirthDate() );
        List<Phone> list = person.getPhones();
        if ( list != null ) {
            personDTO.setPhones( new ArrayList<Phone>( list ) );
        }

        return personDTO;
    }
}
