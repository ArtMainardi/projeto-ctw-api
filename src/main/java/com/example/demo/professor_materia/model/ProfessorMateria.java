package com.example.demo.professor_materia.model;

import com.example.demo.materia.model.Materia;
import com.example.demo.professor.model.Professor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorMateria {
    @Id
    @ManyToOne
    @JoinColumn(name="professor_id_professor")
    private Professor professor;

    @Id
    @ManyToOne
    @JoinColumn(name="materia_id_materia")
    private Materia materia;
}
