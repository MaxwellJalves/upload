package com.java.upload.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.HashMap;

@RestController
@RequestMapping("v1")
@Slf4j
public class MultipartController {

    @PostMapping(value = "multipart", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> salvarFormulario(@RequestParam MultipartFile file, @ModelAttribute Usuario usuario) {

        log.info(String.format("new request for resource /v1/multipart : solicitante = %s", usuario.getNome()));
        return ResponseEntity.created(URI.create("upload")).body(mock(file, usuario));
    }

    private HashMap<String, Object> mock(MultipartFile file, Usuario usuario) {
        var map = new HashMap<String, Object>();
        map.put("NOME_ARQUIVO", file.getOriginalFilename());
        map.put("TAMANHO_ARQUIVO", file.getSize());
        map.put("TAMANHO_KB", file.getSize() / 1024);
        map.put("NOME_USUARIO", usuario.getNome());
        map.put("PROTOCOLO_DA_REQUISICAO", usuario.getProtocolo());

        return map;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Usuario {

    private String nome;
    private String protocolo;

}