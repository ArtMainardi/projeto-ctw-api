package com.ctw.projeto_ctw.alunos_tarefas.repository;

import com.ctw.projeto_ctw.alunos_tarefas.model.AlunosTarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosTarefasRepository extends JpaRepository<AlunosTarefas, Long> {
}
