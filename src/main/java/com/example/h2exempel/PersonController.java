package com.example.h2exempel;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {


    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Person> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person){
        return service.addPerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        service.deletePerson(id);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id){
        return service.getById(id);
    }
}
