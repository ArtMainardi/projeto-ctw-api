package com.ctw.projeto_ctw.mrsc.model;

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
@Table(name = "aluno")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Alunos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aluno;
    // --
    @Column(length = 40, nullable = false)
    private String nome_aluno;
    // --
    @Column(length = 10, unique = true, nullable = false)
    private String matricula_aluno;
    // --
    private LocalDate data_nascimento_aluno;
    // --
    @Column(columnDefinition = "CHAR(11)", unique = true, nullable = false)
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
    @Column(length = 250, unique = true, nullable = false)
    private String email_aluno;
    // --
    @Column(length = 200, nullable = false)
    private String senha_aluno;
    // --
    private int pontuacao = 0;
    // --
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime data_criacao_aluno;
    // --
    private int pontuacao_aluno = 0;
    // --
    @OneToMany(mappedBy = "aluno")
    @JsonIgnore
    List<AlunosTarefas> alunosTarefas;
    // --
    @OneToMany(mappedBy = "aluno")
    @JsonIgnore
    private List<AlunosMaterias> alnMat;

}
