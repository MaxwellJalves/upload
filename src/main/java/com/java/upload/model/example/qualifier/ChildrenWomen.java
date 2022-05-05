package com.java.upload.model.example.qualifier;

import org.springframework.stereotype.Component;

@Component
public class ChildrenWomen implements Parent{

    @Override
    public String action() {
        return "Mulher";
    }
}
