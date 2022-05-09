package com.java.upload.controller;

import com.java.upload.model.enums.TipoDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@RestController
@RequestMapping("v1/datas")
public class DataFormatadaResponseController {

    @GetMapping("pattern")
    public Object getDataFormatEn(@RequestParam TipoDate data) {

        var respose = new HashMap<TipoDate, String>();

        if (TipoDate.BR.equals(data)) {
            respose.put(TipoDate.BR, getDate("dd/MM/yyyy"));
            return respose;
        } else {
            respose.put(TipoDate.EN, getDate("yyyy-MM-dd"));

            return respose;


        }


    }


    private String getDate(String dataFormatada) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(dataFormatada));
    }
}
