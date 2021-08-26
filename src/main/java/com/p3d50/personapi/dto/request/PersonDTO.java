package com.p3d50.personapi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.p3d50.personapi.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;


@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO extends Person {

    private Long id;

    @NotEmpty
    @Size(min=2,max=100)
    private String firstName;

    @NotEmpty
    @Size(min=2,max=100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;
}