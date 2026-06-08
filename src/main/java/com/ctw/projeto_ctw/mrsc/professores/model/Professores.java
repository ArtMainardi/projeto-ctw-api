package com.ctw.projeto_ctw.mrsc.professores.model;

import com.ctw.projeto_ctw.mrsc.professoresMaterias.model.ProfessoresMaterias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "professores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professor;

    @Column(length = 150, nullable = false)
    private String nome_professor;

    @Column(length = 11, nullable = false)
    private String cpf_professor;

    @Column(length = 10, nullable = false)
    private String cadastro_professor;

    @Column(length = 40)
    private String especialidade_professor;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime data_criacao_professor;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] foto_perfil_professor;

    @Column(nullable = false)
    private String senha_professor;

    @Column(length = 40, nullable = false)
    private String email_professor;

    @Column(nullable = false)
    private LocalDate data_nascimento_professor;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean adm;

    @OneToMany(mappedBy = "professor")
    @JsonBackReference
    @JsonIgnore
    private List<ProfessoresMaterias> profMat;
}