package com.ctw.projeto_ctw.conteudos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "conteudos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Conteudos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conteudo;
    // --
    @Column(length = 40)
    private String titulo_conteudo;
    // --
    @Column(columnDefinition = "TEXT")
    private String descricao_conteudo;
    // --
    private LocalDate data_publicacao;
    //--
    // --> Futura relação com MATERIAS
}
