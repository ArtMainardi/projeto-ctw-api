package com.ctw.projeto_ctw.alunos.model;

import com.ctw.projeto_ctw.turmas.model.Turmas;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
