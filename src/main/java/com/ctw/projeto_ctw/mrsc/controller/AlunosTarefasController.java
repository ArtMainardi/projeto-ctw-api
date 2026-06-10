package com.ctw.projeto_ctw.mrsc.controller;

import com.ctw.projeto_ctw.mrsc.model.AlunosTarefas;
import com.ctw.projeto_ctw.mrsc.service.AlunosService;
import com.ctw.projeto_ctw.mrsc.service.AlunosTarefasService;
import com.ctw.projeto_ctw.mrsc.service.TarefasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alunosTarefas")
@RequiredArgsConstructor
@CrossOrigin("*")

public class AlunosTarefasController {
    final AlunosTarefasService service;
    final AlunosService alunosService;
    final TarefasService tarefasService;

    @GetMapping
    public List<AlunosTarefas> listar(){ return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<AlunosTarefas> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping("/{id_aluno}-{id_tarefa}")
    public ResponseEntity<AlunosTarefas> salvar(@RequestBody AlunosTarefas newAlunoTarefa, @PathVariable Long id_aluno, @PathVariable Long id_tarefa){
        newAlunoTarefa.setAluno(alunosService.buscar(id_aluno));
        newAlunoTarefa.setTarefa(tarefasService.buscar(id_tarefa));
        return ResponseEntity.ok(service.salvar(newAlunoTarefa));
    }

    @PutMapping("/{id}/{id_aluno}-{id_tarefa}")
    public ResponseEntity<AlunosTarefas> modificar(@RequestBody AlunosTarefas modifiedAlunoTarefa, @PathVariable Long id,
            @PathVariable Long id_aluno, @PathVariable Long id_tarefa){
        modifiedAlunoTarefa.setAluno(alunosService.buscar(id_aluno));
        modifiedAlunoTarefa.setTarefa(tarefasService.buscar(id_tarefa));
        return ResponseEntity.ok(service.modificar(modifiedAlunoTarefa, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
