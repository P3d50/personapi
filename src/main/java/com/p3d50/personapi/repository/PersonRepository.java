package com.p3d50.personapi.repository;

import com.p3d50.personapi.dto.request.PersonDTO;
import com.p3d50.personapi.entity.Person;
import com.p3d50.personapi.exception.PersonNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    default Person findByCPF(String cpf) {
        Person person = null;
        if(!this.findAll().isEmpty()) {
            for (Person p : this.findAll()) {
                if (p.getCPF().equals(cpf)) {
                    person = p;
                    break;
                }
            }
        }
        return person;
    }


}
