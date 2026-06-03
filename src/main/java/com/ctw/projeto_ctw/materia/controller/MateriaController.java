package com.ctw.projeto_ctw.materia.controller;

import com.ctw.projeto_ctw.materia.model.Materia;
import com.ctw.projeto_ctw.materia.service.MateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materia")
@RequiredArgsConstructor
public class MateriaController {
    private final MateriaService service;

    @GetMapping
    public List<Materia> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Materia> salvar(@RequestBody Materia mat){
        return ResponseEntity.ok(service.salvar(mat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> atualizar(@PathVariable Long id, @RequestBody Materia mat){
        return ResponseEntity.ok(service.atualizar(id, mat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
