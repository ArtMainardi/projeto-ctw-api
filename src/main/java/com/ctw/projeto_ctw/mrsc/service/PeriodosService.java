package com.ctw.projeto_ctw.mrsc.service;

import com.ctw.projeto_ctw.mrsc.model.Periodos;
import com.ctw.projeto_ctw.mrsc.repository.PeriodosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PeriodosService {
    private final PeriodosRepository repository;

    // Listar todos os dados:
    public List<Periodos> listar(){ return repository.findAll(); }

    // Buscar por ID:
    public Periodos buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Periodo não encontrado!"));
    }

    // Salvar:
    public Periodos salvar(Periodos newPeriodo){ return repository.save(newPeriodo); }

    // Modificar:
    public Periodos modificar(Periodos modifiedPeriodo, Long id){
        Periodos newPeriodo = buscar(id);
        newPeriodo.setPeriodo(modifiedPeriodo.getPeriodo());
        return repository.save(newPeriodo);
    }

    // Deletar:
    public void deletar(Long id){
        repository.deleteById(id);
    }
}
