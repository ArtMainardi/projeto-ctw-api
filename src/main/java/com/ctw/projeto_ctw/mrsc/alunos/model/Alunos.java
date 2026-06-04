package com.ctw.projeto_ctw.mrsc.alunos.model;

import com.ctw.projeto_ctw.mrsc.alunosMaterias.model.AlunosMaterias;
import com.ctw.projeto_ctw.mrsc.alunosTarefas.model.AlunosTarefas;
import com.ctw.projeto_ctw.mrsc.turmas.model.Turmas;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Alunos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aluno;
    // --
    @Column(length = 40)
    private String nome_aluno;
    // --
    @Column(length = 10)
    private String matricula_aluno;
    // --
    private LocalDate data_nascimento_aluno;
    // --
    @Column(columnDefinition = "CHAR(11)")
    private String cpf_aluno;
    // --
    @ManyToOne
    @JoinColumn(name = "turmas_id_turma")
    @JsonIgnoreProperties("alunos")
    private Turmas turma;
    // --
    @Column(columnDefinition = "BLOB")
    private byte[] foto_perfil_aluno;
    // --
    @Column(length = 250)
    private String email_aluno;
    // --
    @Column(length = 200)
    private String senha_aluno;
    // --
    @CreationTimestamp
    private LocalDateTime data_criacao_aluno;
    // --
    @OneToMany(mappedBy = "aluno")
    @JsonIgnoreProperties("aluno")
    List<AlunosTarefas> tarefas;

    @OneToMany(mappedBy = "aluno")
    @JsonBackReference
    @JsonIgnore
    private List<AlunosMaterias> alnMat;

}
