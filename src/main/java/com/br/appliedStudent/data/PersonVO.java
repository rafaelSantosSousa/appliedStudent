package com.br.appliedStudent.data;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String Address;
    private String gender;



}
