package com.ctw.projeto_ctw.mrsc.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "materias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_materia;

    @Column(nullable = false)
    private String nome_materia;

    @OneToMany(mappedBy = "materia")
    @JsonIgnore
    @Column(nullable = false)
    private List<ProfessoresMaterias> profMat;

    @OneToMany(mappedBy = "materia")
    @JsonIgnore
    @Column(nullable = false)
    private List<AlunosMaterias> alnMat;

    @OneToMany(mappedBy = "materia")
    @JsonIgnore
    @Column(nullable = false)
    private List<Tarefas> tarefas;
}
