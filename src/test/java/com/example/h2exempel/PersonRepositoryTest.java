package com.example.h2exempel;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
public class PersonRepositoryTest {


    @Autowired
    private PersonRepository repository;


    @Test
    void saveAndFinddAll(){
        //Arrange
        Person p1 = new Person(null, "Bill");
        Person p2 = new Person(null, "Bosse");


        //Act
        repository.save(p1);
        repository.save(p2);

        List<Person> result = repository.findAll();

        //Assert
        assertThat(result).hasSize(2);
        assertThat(result)
                .extracting(Person::getName)
                .containsExactlyInAnyOrder("Bill", "Bosse");

    }
}
