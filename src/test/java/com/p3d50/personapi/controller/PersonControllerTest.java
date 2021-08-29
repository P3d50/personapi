package com.p3d50.personapi.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.p3d50.personapi.dto.request.PersonDTO;
import com.p3d50.personapi.dto.response.MessageResponseDTO;
import com.p3d50.personapi.entity.Phone;
import com.p3d50.personapi.service.PersonService;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PersonController.class})
@ExtendWith(SpringExtension.class)
public class PersonControllerTest {
    @Autowired
    private PersonController personController;

    @MockBean
    private PersonService personService;

    @Test
    public void testListAll() throws Exception {
        when(this.personService.listAll()).thenReturn(new ArrayList<PersonDTO>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/people");
        MockMvcBuilders.standaloneSetup(this.personController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    public void testListAll2() throws Exception {
        when(this.personService.listAll()).thenReturn(new ArrayList<PersonDTO>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/people");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.personController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    public void testFindById() throws Exception {
        when(this.personService.findById((Long) any())).thenReturn(new PersonDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/people/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.personController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":null,\"lastName\":null,\"firstName\":null,\"birthDate\":null,\"phones\":null,\"cpf\":null}"));
    }

    @Test
    public void testDeleteById() throws Exception {
        doNothing().when(this.personService).delete((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/people/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.personController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void testFindByCPF() throws Exception {
        when(this.personService.findByCPF((String) any())).thenReturn(new PersonDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/people/cpf").param("num", "foo");
        MockMvcBuilders.standaloneSetup(this.personController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":null,\"lastName\":null,\"firstName\":null,\"birthDate\":null,\"phones\":null,\"cpf\":null}"));
    }

    @Test
    @Disabled
    public void testUpdateById() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: Unrecoverable runtime error.
        //   Please contact Diffblue support.
        //   See https://diff.blue/E009

        when(this.personService.updateById((Long) any(), (PersonDTO) any())).thenReturn(mock(MessageResponseDTO.class));

        PersonDTO personDTO = new PersonDTO();
        personDTO.setLastName("Doe");
        personDTO.setBirthDate(null);
        personDTO.setCPF("CPF");
        personDTO.setId(123L);
        personDTO.setPhones(new ArrayList<Phone>());
        personDTO.setFirstName("Jane");
        String content = (new ObjectMapper()).writeValueAsString(personDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/people/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.personController).build().perform(requestBuilder);
    }

    @Test
    public void testPostPersons() throws Exception {
        when(this.personService.listAll()).thenReturn(new ArrayList<PersonDTO>());

        PersonDTO personDTO = new PersonDTO();
        personDTO.setLastName("Doe");
        personDTO.setBirthDate(null);
        personDTO.setCPF("CPF");
        personDTO.setId(123L);
        personDTO.setPhones(new ArrayList<Phone>());
        personDTO.setFirstName("Jane");
        String content = (new ObjectMapper()).writeValueAsString(personDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/people")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.personController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

