package com.ctw.projeto_ctw.turmas.model;

import com.ctw.projeto_ctw.alunos.model.Alunos;
import com.ctw.projeto_ctw.periodos.model.Periodos;
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
    private String nome_turma;
    // --
    @ManyToOne
    @JoinColumn(name = "periodos_id_periodo")
    private Periodos periodo;
    // --
    @OneToMany(mappedBy = "turma")
    List<Alunos> alunos;
}
