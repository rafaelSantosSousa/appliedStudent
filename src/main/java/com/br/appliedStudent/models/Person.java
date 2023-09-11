package com.br.appliedStudent.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person",nullable = false)
    private Long id;
    @Column(name = "first_name",nullable = false, length = 80)
    private String firstName;
    @Column(name = "last_name",nullable = false, length = 80)
    private String lastName;
    @Column(nullable = false, length = 100)
    private String Address;
    @Column(nullable = false, length = 6)
    private String gender;


}
