package com.java.upload.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.HashMap;

@RestController
@RequestMapping("v1")
public class MultipartController {

    @PostMapping("multipart")
    public ResponseEntity<Object> salvarFormulario(@RequestParam("file") MultipartFile file, @ModelAttribute Usuario usuario) {
        var size = file.getSize();
        Long tamanho = size / 1024;
        var map = new HashMap<String, Object>();
        map.put("arquivo", file.getOriginalFilename());
        map.put("size", file.getSize());
        map.put("KB", tamanho.floatValue());
        map.put("nome", usuario.getNome());
        map.put("protocolo", usuario.getProtocolo());
        return ResponseEntity.created(URI.create("upload")).body(map);
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