package com.java.upload.model.example.qualifier;

import org.springframework.stereotype.Component;

@Component
public class ChildrenMan implements Parent{

    @Override
    public String action() {
        return "Homem";
    }

}
