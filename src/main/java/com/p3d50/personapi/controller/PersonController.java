package com.p3d50.personapi.controller;

import com.p3d50.personapi.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @GetMapping
    public String getPersons(){
        Person person = new Person();
        return "API test";
    }
}
