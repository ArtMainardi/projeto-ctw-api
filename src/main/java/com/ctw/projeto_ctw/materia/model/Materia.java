package com.ctw.projeto_ctw.materia.model;

import com.ctw.projeto_ctw.professorMateria.model.ProfessorMateria;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_materia;
    private String nome_materia;

    @OneToMany(mappedBy = "materia")
    @JsonBackReference
    @JsonIgnore
    private List<ProfessorMateria> profMat;
}
