package com.java.upload.service.impl;

import com.java.upload.model.Arquivos;
import com.java.upload.repository.ArquivosRepository;
import com.java.upload.service.ArquivoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@AllArgsConstructor

public class ArquivoServiceImpl implements ArquivoService {

    private final String DIRETORIO = "E:/repo/";

    private ArquivosRepository arquivosRepository;

    @Override
    public void uploadLocal(MultipartFile file) {

        try {

            var obterBytes = file.getBytes();
            Path path = Paths.get(DIRETORIO.concat(file.getOriginalFilename()));
            Files.write(path, obterBytes);

        } catch (IOException e) {
            System.err.println(e);
            throw new IllegalArgumentException("Não foi possivel salvar o arquivo \t :" + file.getOriginalFilename());
        }

    }

    @Override
    public void uploadDataBase(MultipartFile file) {

        try {

            var arquivo = Arquivos.builder()
                    .formato(file.getContentType())
                    .arquivoData(file.getBytes())
                    .descricao(file.getOriginalFilename())
                    .tamanho(String.valueOf(file.getSize()))
                    .build();

            arquivosRepository.save(arquivo);

        } catch (IOException e) {
            throw new IllegalArgumentException("Não foi possivel salvar o arquivo \t :" + file.getOriginalFilename());
        }

    }
}
