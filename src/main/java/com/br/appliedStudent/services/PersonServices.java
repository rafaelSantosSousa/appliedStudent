package com.br.appliedStudent.services;

import com.br.appliedStudent.data.PersonVO;
import com.br.appliedStudent.data.PersonVO2;
import com.br.appliedStudent.exceptions.ResourceNotFoundException;
import com.br.appliedStudent.mapper.DozerMapper;
import com.br.appliedStudent.mapper.custom.PersonMapper;
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

    @Autowired
    PersonMapper mapper;


    public List<PersonVO> findAll(){
        logger.info("Finding all people!");
         return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){

        logger.info("Finding one person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person){
        logger.info("Creating one person");
        var entity = DozerMapper.parseObject(person,Person.class);
        var vo = DozerMapper.parseObject (repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO2 createV2(PersonVO2 person){
        logger.info("Creating one person with V2!");
        var entity = mapper.convertEntityToVo2(person);
        var vo = mapper.convertEntityToVo(repository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO person){
        logger.info("Updating one person");
        var entity = repository.findById(person.getId())
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject (repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id){
        logger.info("Deleting one person");

        var entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

}
