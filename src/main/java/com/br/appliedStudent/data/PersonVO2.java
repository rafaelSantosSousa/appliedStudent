package com.br.appliedStudent.data;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonVO2  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String Address;
    private String gender;
    private Date birthDay;


}

