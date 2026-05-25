package com.example.demo.cardapio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cardapio;
    @Column(nullable = false)
    private LocalDate data_refeicao;
    @Lob
    @Column(nullable = false)
    private String descricao_refeicao;
    @Column(nullable = false)
    private tipoRefeicao tipo_refeicao;
}

enum tipoRefeicao{
    JANTA,
    ALMOÇO
}