package com.ctw.projeto_ctw.mrsc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("materias")
    private Materias materia;

    @ManyToOne
    @JoinColumn(name="id_aluno", nullable = false)
    @JsonIgnoreProperties("alunos")
    private Alunos aluno;
}
