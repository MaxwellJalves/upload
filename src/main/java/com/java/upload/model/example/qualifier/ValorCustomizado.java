package com.java.upload.model.example.qualifier;

import org.springframework.stereotype.Component;

@Component
public class ValorCustomizado implements Parent{


    @Override
    public String action() {
        return "Valor obtivo através da classe customizada : Parent";
    }
}
