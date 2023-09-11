package com.br.appliedStudent.data.vo.vo1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//Anotação @JsonPropertyOrder serve para alterar ordem dos atributos nas requisições
//alterar o nome da requisição das colunas é a Anotação @JsonProperty
@JsonPropertyOrder({"id","address","lastName","firstName","gender"})
public class PersonVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String Address;
    private String gender;



}
