package com.java.upload.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Arquivos {

    @Id
    @GeneratedValue(generator = "uuid")
    @JsonProperty("Identificador")
    private String id;

    @JsonProperty("Arquivo")
    private String arquivo;

    @JsonProperty("Formato")
    private String formato;

    @JsonProperty("Tamanho")
    private String tamanho;

}
