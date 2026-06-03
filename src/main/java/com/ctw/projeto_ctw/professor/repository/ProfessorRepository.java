package com.ctw.projeto_ctw.professor.repository;

import com.ctw.projeto_ctw.professor.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
