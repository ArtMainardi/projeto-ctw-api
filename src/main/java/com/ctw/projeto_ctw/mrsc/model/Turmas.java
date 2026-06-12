package com.ctw.projeto_ctw.mrsc.model;

import com.ctw.projeto_ctw.mrsc.model.Alunos;
import com.ctw.projeto_ctw.mrsc.model.Periodos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "turmas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Turmas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_turma;
    // --
    @Column(nullable = false)
    private String nome_turma;
    // --
    @ManyToOne
    @JoinColumn(name = "periodos_id_periodo")
    @JsonIgnoreProperties("turmas")
    @Column(nullable = false)
    private Periodos periodo;
    // --
    @OneToMany(mappedBy = "turma")
    @JsonIgnoreProperties("turma")
    List<Alunos> alunos;
}
