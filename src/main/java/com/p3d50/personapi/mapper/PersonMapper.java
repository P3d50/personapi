package com.p3d50.personapi.mapper;

import com.p3d50.personapi.dto.request.PersonDTO;
import com.p3d50.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
