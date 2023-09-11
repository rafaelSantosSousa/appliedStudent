package com.br.appliedStudent.data.vo.vo2;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVO2 personVO2 = (PersonVO2) o;
        return Objects.equals(id, personVO2.id) && Objects.equals(firstName, personVO2.firstName) && Objects.equals(lastName, personVO2.lastName) && Objects.equals(Address, personVO2.Address) && Objects.equals(gender, personVO2.gender) && Objects.equals(birthDay, personVO2.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, Address, gender, birthDay);
    }


}

