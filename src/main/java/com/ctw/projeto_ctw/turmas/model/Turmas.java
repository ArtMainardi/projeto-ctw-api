package com.ctw.projeto_ctw.turmas.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "turmas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Turmas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_turma;

    private String nome_turma;
    private String periodo_turma;
}
