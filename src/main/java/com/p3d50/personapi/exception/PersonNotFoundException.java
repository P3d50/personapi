package com.p3d50.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception{

    public PersonNotFoundException(long id){
        super("Person not found with ID:"+id);
    }

    public PersonNotFoundException(String str){
        super("Person not found: "+str);
    }
}
