package com.ctw.projeto_ctw.mrsc.service;

import com.ctw.projeto_ctw.mrsc.model.AlunosTarefas;
import com.ctw.projeto_ctw.mrsc.repository.AlunosTarefasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AlunosTarefasService {
    final AlunosTarefasRepository repository;

    // Listar tudo:
    public List<AlunosTarefas> listar(){ return repository.findAll(); }

    // Buscar por ID:
    public AlunosTarefas buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Erro: tarefa do aluno não encontrada!"));
    }

    // Salvar:
    public AlunosTarefas salvar(AlunosTarefas newAlunoTarefa){ return repository.save(newAlunoTarefa); }

    // Modificar:
    public AlunosTarefas modificar(AlunosTarefas alunoTarefaModified, Long id){
        AlunosTarefas newAlunoTarefa = buscar(id);
        newAlunoTarefa.setAluno(alunoTarefaModified.getAluno());
        newAlunoTarefa.setTarefa(alunoTarefaModified.getTarefa());
        newAlunoTarefa.setNota(alunoTarefaModified.getNota());
        newAlunoTarefa.setConclusao(alunoTarefaModified.isConclusao());
        return repository.save(newAlunoTarefa);
    }

    // Deletar:
    public void deletar(Long id){ repository.deleteById(id); }
}
