package com.example.demo.noticias.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

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
    @Column(length = 40, nullable = false)
    private String titulo_noticia;
    @Lob
    @Column(nullable = false)
    private String texto_noticia;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime data_publicacao;
    @Lob
    private byte[] imagem_noticia;
}