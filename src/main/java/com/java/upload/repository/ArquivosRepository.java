package com.java.upload.repository;

import com.java.upload.model.Arquivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquivosRepository extends JpaRepository<Arquivos,String> {
}
