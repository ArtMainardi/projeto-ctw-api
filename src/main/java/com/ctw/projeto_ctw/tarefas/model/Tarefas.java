package com.ctw.projeto_ctw.tarefas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

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
    @Column(length = 40)
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
    // Futuramente implementar FK com a tabela MATERIAS
}
