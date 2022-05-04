package com.java.upload.controller;

import com.java.upload.service.impl.ArquivoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping("v1/upload")
@Slf4j
public class UploadController {

    @Autowired
    private ArquivoServiceImpl arquivoService;

    @PostMapping(
            value = "local",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadLocal(@RequestParam MultipartFile file) throws Throwable {
        log.info("Chamado realizada no recurso {uploadLocal} /" + file.getOriginalFilename());
        try {
            arquivoService.uploadLocal(file);
            return ResponseEntity.ok("Upload realizado com sucesso.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST).getCause();
        }

    }

    @PostMapping(
            value = "database",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> salvarNoBancoDeDados(@RequestParam MultipartFile file) throws Throwable{
        log.info("Chamado realizada no recurso {dataBase} /" + file.getOriginalFilename());
        try {
            arquivoService.uploadDataBase(file);
            return ResponseEntity.created(URI.create("v1/upload/database")).body("Registro adicionado na base de dados.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST).getCause();
        }
    }
}
