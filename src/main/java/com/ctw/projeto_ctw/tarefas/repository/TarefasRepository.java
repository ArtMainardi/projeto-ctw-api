package com.ctw.projeto_ctw.tarefas.repository;

import com.ctw.projeto_ctw.tarefas.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
}