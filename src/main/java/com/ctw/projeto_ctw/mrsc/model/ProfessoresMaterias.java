package com.ctw.projeto_ctw.mrsc.model;

import com.ctw.projeto_ctw.mrsc.model.Materias;
import com.ctw.projeto_ctw.mrsc.model.Professores;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professoresMaterias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessoresMaterias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professor_materia;

    @ManyToOne
    @JoinColumn(name="id_professor", nullable = false)
    @JsonManagedReference
    private Professores professor;

    @ManyToOne
    @JoinColumn(name="id_materia", nullable = false)
    @JsonManagedReference
    private Materias materia;
}
