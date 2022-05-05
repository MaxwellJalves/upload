package com.java.upload.Uteis;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUteis {

    private FileUteis() {
        throw new IllegalStateException("Classe utilitaria.");
    }

    public static Resource convertByteEmResource(byte[] bytes, String tipoArquivo) throws IOException {

        File file = File.createTempFile("prefixo", String.format(".%s", tipoArquivo));
        try (FileOutputStream arquivo = new FileOutputStream(file)) {
            arquivo.write(bytes);
            return new FileSystemResource(file);
        }
    }
}
