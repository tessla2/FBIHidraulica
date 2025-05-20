package com.empresa.site.service;

import com.empresa.site.model.Image;
import com.empresa.site.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image salvarImagem(MultipartFile file) throws IOException {
        Image imagem = new Image();

        imagem.setNomeArquivo(file.getOriginalFilename());
        imagem.setDataUpload(LocalDateTime.now()); // Corrigido aqui
        imagem.setDados(file.getBytes()); // Salva conteúdo binário da imagem
        imagem.setCaminho("siteh"); // opcional, pode usar para marcar origem

        return imageRepository.save(imagem);
    }

    public Optional<Image> getImagemPorNome(String nomeArquivo) {
        return imageRepository.findByNomeArquivo(nomeArquivo);
    }

}
