package com.ctw.projeto_ctw.alunos.repository;
import com.ctw.projeto_ctw.alunos.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<Alunos, Long> {
}
