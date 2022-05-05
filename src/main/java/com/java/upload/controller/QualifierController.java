package com.java.upload.controller;


import com.java.upload.model.example.qualifier.Customizacao;
import com.java.upload.model.example.qualifier.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("qualifier")
public class QualifierController {


    @Autowired
    @Qualifier("childrenWomen")
    private Parent parent;

    @Qualifier("childrenMan")
    @Autowired
    private Parent homem;


    @Autowired
    @Customizacao("valorCustomizado")
    private Parent valorCustomizado;

    @GetMapping
    public Object get(){

        return Arrays.asList(parent.action(),homem.action(),valorCustomizado.action());
    }

}
