package com.empresa.site.service;

import com.empresa.site.model.Image;
import com.empresa.site.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;

@Service
public class ImageService {

    private final Path uploadDir = Paths.get("uploads");

    @Autowired
    private ImageRepository imageRepository;

    public Image salvarImagem(MultipartFile file) throws IOException {
        Image imagem = new Image();

        imagem.setNomeArquivo(file.getOriginalFilename());
        imagem.setData(LocalDateTime.now());
        imagem.setDados(file.getBytes());

        return imageRepository.save(imagem);
    }

}
