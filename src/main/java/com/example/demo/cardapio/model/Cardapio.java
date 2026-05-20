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
    private LocalDate data_refeicao;
    @Lob
    private String descricao_refeicao;
    private tipoRefeicao tipo_refeicao;
}

enum tipoRefeicao{
    JANTA,
    ALMOÇO
}