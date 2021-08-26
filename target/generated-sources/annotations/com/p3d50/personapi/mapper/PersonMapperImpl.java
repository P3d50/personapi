package com.p3d50.personapi.mapper;

import com.p3d50.personapi.dto.request.PersonDTO;
import com.p3d50.personapi.entity.Person;
import com.p3d50.personapi.entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-26T06:56:09-0300",
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
        List<Phone> list = personDTO.getPhone();
        if ( list != null ) {
            person.setPhone( new ArrayList<Phone>( list ) );
        }

        return person;
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setBirthDate( person.getBirthDate() );
        personDTO.setId( person.getId() );
        personDTO.setLastName( person.getLastName() );
        personDTO.setFirstName( person.getFirstName() );
        personDTO.setCpf( person.getCpf() );
        List<Phone> list = person.getPhone();
        if ( list != null ) {
            personDTO.setPhone( new ArrayList<Phone>( list ) );
        }

        return personDTO;
    }
}
