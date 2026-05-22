package com.example.demo.materia.model;

import com.example.demo.professor.model.Professor;
import com.example.demo.professorMateria.model.ProfessorMateria;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties(value = {"professor", "materia"})
    private List<ProfessorMateria> profMat;
}
