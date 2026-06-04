package com.ctw.projeto_ctw.alunosMaterias.model;

import com.ctw.projeto_ctw.alunos.model.Alunos;
import com.ctw.projeto_ctw.materias.model.Materias;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alunosMaterias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunosMaterias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_materia", nullable = false)
    @JsonManagedReference
    private Materias materia;

    @ManyToOne
    @JoinColumn(name="id_aluno", nullable = false)
    @JsonManagedReference
    private Alunos aluno;
}
