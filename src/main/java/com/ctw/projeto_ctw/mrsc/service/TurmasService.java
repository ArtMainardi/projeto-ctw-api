package com.ctw.projeto_ctw.mrsc.service;

import com.ctw.projeto_ctw.mrsc.model.Turmas;
import com.ctw.projeto_ctw.mrsc.repository.TurmasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TurmasService {
    private final TurmasRepository repository;

    // Listar todos os dados:
    public List<Turmas> listar(){ return repository.findAll(); }

    // Buscar pelo ID:
    public Turmas buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    // Salvar um dado:
    public Turmas salvar(Turmas turma) { return repository.save(turma); }

    // Modificar um dado:
    public Turmas modificar(Turmas modifiedTurma, Long id){
        Turmas newTurma = buscar(id);
        newTurma.setNome_turma(modifiedTurma.getNome_turma());
        newTurma.setPeriodo(modifiedTurma.getPeriodo());
        return repository.save(newTurma);
    }

    // Deletar um dado:
    public void deletar(Long id){ repository.deleteById(id); }

    public List<Turmas> rank(){
        return repository.ordenarPorNotas().subList(0, 3);
    }
}
