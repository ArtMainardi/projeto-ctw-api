package com.ctw.projeto_ctw.mrsc.controller;

import com.ctw.projeto_ctw.mrsc.model.Alunos;
import com.ctw.projeto_ctw.mrsc.service.AlunosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
@CrossOrigin("*")

public class AlunosController {
    private final AlunosService service;

    @GetMapping
    public List<Alunos> listar(){ return service.listar(); }
    // --
    @GetMapping("/{id}")
    public ResponseEntity<Alunos> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }
    // --
    @PostMapping
    public ResponseEntity<Alunos> salvar(@RequestBody Alunos newAluno){
        return ResponseEntity.ok(service.salvar(newAluno));
    }
    // --
    @PutMapping("/{id}")
    public ResponseEntity<Alunos> modificar(@RequestBody Alunos modifiedAluno, @PathVariable Long id){
        return ResponseEntity.ok(service.modificar(modifiedAluno, id));
    }
    // --
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
