package com.ctw.projeto_ctw.mrsc.controller;

import com.ctw.projeto_ctw.mrsc.model.AlunosMaterias;
import com.ctw.projeto_ctw.mrsc.service.AlunosMateriasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno-materia")
@RequiredArgsConstructor
public class AlunosMateriasController {

    private final AlunosMateriasService service;

    @GetMapping
    public List<AlunosMaterias> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunosMaterias> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/aluno={id_aluno}/materia={id_materia}")
    public ResponseEntity<AlunosMaterias> salvar(@PathVariable Long id_aluno, @PathVariable Long id_materia){
        return ResponseEntity.ok(service.salvar(id_aluno, id_materia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunosMaterias> atualizar(@PathVariable Long id, @RequestBody AlunosMaterias alnMat){
        return ResponseEntity.ok(service.atualizar(alnMat, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
