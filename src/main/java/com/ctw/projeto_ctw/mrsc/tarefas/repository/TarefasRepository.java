package com.ctw.projeto_ctw.mrsc.tarefas.repository;

import com.ctw.projeto_ctw.mrsc.tarefas.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
}