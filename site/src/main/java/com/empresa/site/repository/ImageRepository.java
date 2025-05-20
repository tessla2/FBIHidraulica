package com.empresa.site.repository;

import com.empresa.site.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByNomeArquivo(String nomeArquivo);
}
