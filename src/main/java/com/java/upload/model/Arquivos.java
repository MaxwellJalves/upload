package com.java.upload.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Arquivos {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    @JsonProperty("Identificador")
    private String id;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("Formato")
    private String formato;

    @JsonProperty("Tamanho")
    private String tamanho;

    @Lob
    private byte[] arquivoData;

}
