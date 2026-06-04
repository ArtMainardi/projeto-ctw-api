package com.ctw.projeto_ctw.materias.model;

import com.ctw.projeto_ctw.alunosMaterias.model.AlunosMaterias;
import com.ctw.projeto_ctw.professoresMaterias.model.ProfessoresMaterias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String nome_materia;

    @OneToMany(mappedBy = "materia")
    @JsonBackReference
    @JsonIgnore
    private List<ProfessoresMaterias> profMat;

    @OneToMany(mappedBy = "materia")
    @JsonBackReference
    @JsonIgnore
    private List<AlunosMaterias> alnMat;
}
