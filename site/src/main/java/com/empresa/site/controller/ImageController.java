package com.empresa.site.controller;

import com.empresa.site.model.Image;
import com.empresa.site.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Image imagem = imageService.salvarImagem(file);
            return ResponseEntity.ok("Imagem salva! Caminho: " + imagem.getCaminho());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao salvar imagem: " + e.getMessage());
        }
    }
}
