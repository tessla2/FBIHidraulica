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

    // getters e setters


    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void setCaminho() {
        this.caminho = caminho;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setData(LocalDateTime bytes) {
        this.data = data; // isso não faz sentido, precisa de um setter correto para data
    }

    public void setDados(byte[] bytes) {
        this.dados = dados;
    }
}
