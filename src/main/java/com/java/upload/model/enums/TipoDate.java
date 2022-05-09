package com.java.upload.model.enums;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public enum TipoDate {

    BR("Brasileiro"),
    EN("Americado");

    private String value;

    TipoDate(String formato){
        this.value = formato;
    }
}
