package com.empresa.site.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "imagens")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_arquivo")
    private String nomeArquivo;

    @Column(name = "caminho")
    private String caminho;

    @Column(name = "data_upload")
    private LocalDateTime data;

    @Column(name = "dados")
    private byte[] dados;

    // Getters e setters

    public Long getId() {
        return id;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setDataUpload(LocalDateTime data) {
        this.data = data;
    }

    public byte[] getDados() {
        return dados;
    }

    public void setDados(byte[] dados) {
        this.dados = dados;
    }
}
