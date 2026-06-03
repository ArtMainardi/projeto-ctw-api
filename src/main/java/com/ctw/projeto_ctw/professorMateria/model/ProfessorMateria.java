package com.ctw.projeto_ctw.professorMateria.model;

import com.ctw.projeto_ctw.materia.model.Materia;
import com.ctw.projeto_ctw.professor.model.Professor;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
