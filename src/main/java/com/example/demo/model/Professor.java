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
    Long id_professor;
    @Column(length = 11)
    String cpf_professor;
    @Column(length = 10)
    String cadastro_professor;
    @Column(length = 40)
    String especialidade_professor;
    LocalDate data_criacao_professor;
    @Lob
    @Column(columnDefinition = "BLOB")
    byte[] foto_perfil_professor;
    String senha_professor;
    @Column(length = 40)
    String email_professor;
    LocalDate data_nascimento_professor;
    @ManyToOne
    @JoinColumn(name="materia_id_materia")
    Long id_materia;
}