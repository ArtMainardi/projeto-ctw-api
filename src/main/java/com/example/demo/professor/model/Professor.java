package com.example.demo.professor.model;

import com.example.demo.materia.model.Materia;
import com.example.demo.professor_materia.model.ProfessorMateria;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professor;

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

    @OneToMany(mappedBy = "professor")
    @JsonIgnoreProperties("professor")
    private List<ProfessorMateria> pm;
}