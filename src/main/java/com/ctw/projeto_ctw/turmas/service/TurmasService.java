package com.ctw.projeto_ctw.turmas.service;

import com.ctw.projeto_ctw.turmas.model.TurmasModel;
import com.ctw.projeto_ctw.turmas.repository.TurmasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TurmasService {
    private final TurmasRepository repository;

    // Listar todos os dados:
    public List<TurmasModel> listar(){ return repository.findAll(); }

    // Buscar pelo ID:
    public TurmasModel buscar(long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    // Salvar um dado:
    public TurmasModel salvar(TurmasModel turma) { return repository.save(turma); }

    // Modificar um dado:
    public TurmasModel modificar(TurmasModel modifiedTurma, long id){
        TurmasModel newTurma = buscar(id);
        newTurma.setNome_turma(modifiedTurma.getNome_turma());
        newTurma.setPeriodo_turma(modifiedTurma.getPeriodo_turma());
        return repository.save(newTurma);
    }

    // Deletar um dado:
    public void deletar(long id){ repository.deleteById(id); }
}
