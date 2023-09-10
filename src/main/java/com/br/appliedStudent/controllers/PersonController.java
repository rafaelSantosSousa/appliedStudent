package com.br.appliedStudent.controllers;

import com.br.appliedStudent.dtos.PersonDto;
import com.br.appliedStudent.models.Person;
import com.br.appliedStudent.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDto> findAll() {
        return service.findAll();
    }


    @GetMapping (value = "/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto findById(@PathVariable(value="id")Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto create(@RequestBody PersonDto person) {
        return service.create(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto update(@RequestBody PersonDto person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete (@PathVariable(value="id")Long id){
         service.delete(id);
         return ResponseEntity.noContent().build();
    }
}
