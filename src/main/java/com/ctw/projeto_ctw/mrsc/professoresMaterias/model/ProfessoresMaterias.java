package com.ctw.projeto_ctw.mrsc.professoresMaterias.model;

import com.ctw.projeto_ctw.mrsc.materias.model.Materias;
import com.ctw.projeto_ctw.mrsc.professores.model.Professores;
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
    @JoinColumn(name="id_professor")
    @JsonManagedReference
    private Professores professor;

    @ManyToOne
    @JoinColumn(name="id_materia")
    @JsonManagedReference
    private Materias materia;
}
