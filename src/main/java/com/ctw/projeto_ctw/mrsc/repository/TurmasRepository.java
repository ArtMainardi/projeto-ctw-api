package com.ctw.projeto_ctw.mrsc.repository;

import com.ctw.projeto_ctw.mrsc.model.Turmas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurmasRepository extends JpaRepository<Turmas, Long> {
    @Query(value = "select turmas.* from turmas join alunos_tarefas on alunos.id_aluno = alunos_tarefas.id_aluno join alunos on turmas.id_turma = alunos.turmas_id_turma group by turmas.id_turma order by sum(alunos_tarefas.nota) desc", nativeQuery = true)
    List<Turmas> ordenarPorNotas();
}
