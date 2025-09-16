package com.example.h2exempel;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {


    private PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public List<Person> getAll(){
        return repo.findAll();
    }

    public Person addPerson(Person person){
        return repo.save(person);
    }

    public void deletePerson(Long id){
        repo.deleteById(id);
    }

    public Person getById(Long id){
        return repo.findById(id).orElse(null);
    }
}
