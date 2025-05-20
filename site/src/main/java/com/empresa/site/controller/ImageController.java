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


    @GetMapping("/{nomeArquivo}")
    public ResponseEntity<byte[]> getImagem(@PathVariable String nomeArquivo) {
        return imageService.getImagemPorNome(nomeArquivo)
                .map(imagem -> {
                    String contentType = "image/jpeg"; // padrão
                    if (nomeArquivo.toLowerCase().endsWith(".png")) {
                        contentType = "image/png";
                    } else if (nomeArquivo.toLowerCase().endsWith(".gif")) {
                        contentType = "image/gif";
                    }
                    return ResponseEntity.ok()
                            .header("Content-Type", contentType)
                            .body(imagem.getDados());
                })
                .orElse(ResponseEntity.notFound().build());
    }



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
