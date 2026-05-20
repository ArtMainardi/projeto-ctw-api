package com.example.demo.noticias.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Noticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_noticias;
    @Column(length = 40)
    private String titulo_noticia;
    @Lob
    private String texto_noticia;
    private LocalDateTime data_publicacao;
    @Lob
    private byte[] imagem_noticia;
}