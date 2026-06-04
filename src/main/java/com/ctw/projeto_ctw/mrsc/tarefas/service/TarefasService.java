package com.ctw.projeto_ctw.mrsc.tarefas.service;

import com.ctw.projeto_ctw.mrsc.tarefas.model.Tarefas;
import com.ctw.projeto_ctw.mrsc.tarefas.repository.TarefasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TarefasService {
    private final TarefasRepository repository;

    // Listar todos os dados:
    public List<Tarefas> listar(){ return repository.findAll(); }

    // Buscar por id:
    public Tarefas buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
    }

    // Salvar dado:
    public Tarefas salvar(Tarefas newTarefa) { return repository.save(newTarefa); }

    // Modificar um dado:
    public Tarefas modificar(Tarefas modifiedTarefa, Long id){
        Tarefas newTarefa = buscar(id);
        newTarefa.setTitulo_tarefa(modifiedTarefa.getTitulo_tarefa());
        newTarefa.setTexto_tarefa(modifiedTarefa.getTexto_tarefa());
        newTarefa.setData_entrega_tarefa(modifiedTarefa.getData_entrega_tarefa());
        return repository.save(newTarefa);
    }

    // Deletar um dado:
    public void deletar(Long id){ repository.deleteById(id); }
}
