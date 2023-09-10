package com.br.appliedStudent.mapper.custom;

import com.br.appliedStudent.data.PersonVO2;
import com.br.appliedStudent.models.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVO2 convertEntityToVo (Person person){
        PersonVO2 vo = new PersonVO2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setBirthDay(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());

        return vo;

    }

    public Person convertEntityToVo2 (PersonVO2 person){
        Person vo = new Person();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        //vo.setBirthDay(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());

        return vo;
    }



}
