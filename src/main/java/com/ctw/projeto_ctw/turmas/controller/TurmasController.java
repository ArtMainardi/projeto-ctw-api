package com.ctw.projeto_ctw.turmas.controller;

import com.ctw.projeto_ctw.turmas.model.TurmasModel;
import com.ctw.projeto_ctw.turmas.service.TurmasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/turmas")
@CrossOrigin("*")

public class TurmasController {
    private final TurmasService service;

    @GetMapping
    public List<TurmasModel> listar(){ return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<TurmasModel> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<TurmasModel> salvar(@RequestBody TurmasModel newTurma){
        return ResponseEntity.ok(service.salvar(newTurma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmasModel> modificar(@RequestBody TurmasModel modifiedTurma, @PathVariable Long id){
        return ResponseEntity.ok(service.modificar(modifiedTurma, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
