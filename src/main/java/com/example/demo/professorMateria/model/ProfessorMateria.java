package com.example.demo.professorMateria.model;

import com.example.demo.materia.model.Materia;
import com.example.demo.professor.model.Professor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professor_materia;

    @ManyToOne
    @JoinColumn(name="id_professor")
    @JsonManagedReference
    private Professor professor;

    @ManyToOne
    @JoinColumn(name="id_materia")
    @JsonManagedReference
    private Materia materia;
}
