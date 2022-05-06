package com.java.upload.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EstudoBase64 {

    public static  final String PONTO_DE_ENTRADA="Texto que será codificado.";


    public static void main(String[] args) {

        var encodeToString = Base64.getEncoder().encodeToString(PONTO_DE_ENTRADA.getBytes(StandardCharsets.UTF_8));
        System.out.format("Codificação de String : UTF_8 :: %s \n\n",encodeToString);

        var decodificar = Base64.getDecoder().decode(encodeToString.getBytes(StandardCharsets.UTF_8));
        System.out.format("Decodificando bytes para String : UTF_8 :: %s ",new String(decodificar));

    }

}
