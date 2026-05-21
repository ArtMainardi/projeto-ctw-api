package com.example.demo.materia.repository;

import com.example.demo.materia.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
}
