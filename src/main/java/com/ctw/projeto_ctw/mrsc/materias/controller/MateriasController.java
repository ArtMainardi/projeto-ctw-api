package com.ctw.projeto_ctw.mrsc.materias.controller;

import com.ctw.projeto_ctw.mrsc.materias.model.Materias;
import com.ctw.projeto_ctw.mrsc.materias.service.MateriasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materia")
@RequiredArgsConstructor
public class MateriasController {
    private final MateriasService service;

    @GetMapping
    public List<Materias> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materias> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Materias> salvar(@RequestBody Materias mat){
        return ResponseEntity.ok(service.salvar(mat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materias> atualizar(@PathVariable Long id, @RequestBody Materias mat){
        return ResponseEntity.ok(service.atualizar(id, mat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
