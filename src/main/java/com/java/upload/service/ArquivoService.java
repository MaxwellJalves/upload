package com.java.upload.service;

import org.springframework.web.multipart.MultipartFile;


public interface ArquivoService {


    public void uploadLocal(MultipartFile file);

    public void uploadDataBase(MultipartFile file);
}
