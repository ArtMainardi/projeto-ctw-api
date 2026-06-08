package com.ctw.projeto_ctw.mrsc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

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
    // --
    @OneToMany(mappedBy = "periodo")
    @JsonIgnoreProperties("periodo")
    List<Turmas> turmas;
}
