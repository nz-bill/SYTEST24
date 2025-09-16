package com.example.h2exempel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)  //modernare sätt än att öppna mocks i init/constructor
@ActiveProfiles("test")
//@SpringBootTest
class PersonServiceTest {


    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService service;
//    @BeforeEach
//    void init(){
//        MockitoAnnotations.openMocks(this);
//    }

    //    public PersonServiceTest(){
//        MockitoAnnotations.openMocks(this);
//    }
    @Test
    void getById_returnsPerson(){
        //Arrange
        Person person = new Person(1L, "Bosse");
        when(repository.findById(1L)).thenReturn(Optional.of(person));

        //Act
        Person result = service.getById(1L);

        //Assert
        assertThat(result.getName()).isEqualTo("Bosse");
        verify(repository).findById(1L);

    }

    @Test
    void addPerson_savesPerson(){
        //Arrange
        Person person = new Person(null,"Bob");
        Person savedPerson = new Person(2L,"Bob" );

        when(repository.save(person)).thenReturn(savedPerson);

        //Act

        Person result = service.addPerson(person);

        //Assert
        assertThat(result.getId()).isEqualTo(2L);
        verify(repository).save(person);

    }




}