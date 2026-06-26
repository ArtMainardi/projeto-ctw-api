package com.ctw.projeto_ctw.mrsc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tarefas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tarefas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarefa;
    // --
    @Column(length = 40, nullable = false)
    private String titulo_tarefa;
    // --
    private String texto_tarefa;
    // --
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime data_publicacao_tarefa;
    // --
    private LocalDateTime data_entrega_tarefa;
    // --
    @ManyToOne
    @JoinColumn(name="id_materia", nullable = false)
    private Materias materia;
    // --
    @OneToMany(mappedBy = "tarefa")
    @JsonIgnore
    private List<AlunosTarefas> alunosTarefas;
}
