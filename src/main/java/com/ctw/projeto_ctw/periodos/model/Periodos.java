package com.ctw.projeto_ctw.periodos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "periodos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Periodos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_periodo;
    // --
    @Column(length = 20)
    private String periodo;
}
