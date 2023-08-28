package com.br.appliedStudent.services;

import com.br.appliedStudent.exceptions.ResourceNotFoundException;
import com.br.appliedStudent.models.Person;
import com.br.appliedStudent.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;
@Service
public class PersonServices {


    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;
    public List<Person> findAll(){

        logger.info("Finding all people!");
         return repository.findAll();
    }

    public Person findById(Long id){

        logger.info("Finding one Person!");
        Person person = new Person();

        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAddress("Uberlandia - Minas Gerais");
        person.setGender("Male");

        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Person create(Person person){
        logger.info("Creating one person");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one person");
        var entity = repository.findById(person.getId())
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting one person");

        var entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

}
