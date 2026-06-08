package com.ctw.projeto_ctw.mrsc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alunos_tarefas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AlunosTarefas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alunos_tarefas;
    // --
    @Column(columnDefinition = "DECIMAL(5, 2)")
    private double nota;
    // --
    @Column(columnDefinition = "BOOL")
    private boolean conclusao = false;
    // --
    @ManyToOne
    @JoinColumn(name = "id_aluno")
    @JsonIgnoreProperties("tarefas")
    private Alunos aluno;
    // --
    @ManyToOne
    @JoinColumn(name = "id_tarefa")
    @JsonIgnoreProperties("tarefas")
    private Tarefas tarefa;
}
