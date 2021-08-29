package com.p3d50.personapi.utils;

import com.p3d50.personapi.entity.Person;
import com.p3d50.personapi.entity.Phone;

import java.time.LocalDate;
import java.util.ArrayList;

public class PersonUtils {


    public static Person getDefaulTestPerson() {

        return Person.builder()
                .firstName("Pedro")
                .lastName("Marcos")
                .CPF("454.999.444.90")
                .phones(new ArrayList<Phone>())
                .build();
    }
}
