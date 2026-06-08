package com.ctw.projeto_ctw.mrsc.controller;

import com.ctw.projeto_ctw.mrsc.model.Tarefas;
import com.ctw.projeto_ctw.mrsc.service.TarefasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class TarefasController {
    private final TarefasService service;

    @GetMapping
    public List<Tarefas> listar(){ return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefas> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Tarefas> salvar(@RequestBody Tarefas newTarefa){
        return ResponseEntity.ok(service.salvar(newTarefa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefas> modificar(@RequestBody Tarefas modifiedTarefa, @PathVariable Long id){
        return ResponseEntity.ok(service.modificar(modifiedTarefa, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
