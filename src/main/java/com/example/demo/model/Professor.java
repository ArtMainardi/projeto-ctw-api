package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_professor;
    @Column(length = 11)
    private String cpf_professor;
    @Column(length = 10)
    private String cadastro_professor;
    @Column(length = 40)
    private String especialidade_professor;
    private LocalDate data_criacao_professor;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] foto_perfil_professor;
    private String senha_professor;
    @Column(length = 40)
    private String email_professor;
    private LocalDate data_nascimento_professor;
    @ManyToOne
    @JoinColumn(name="materia_id_materia", nullable = false)
    private Materia materia;
}