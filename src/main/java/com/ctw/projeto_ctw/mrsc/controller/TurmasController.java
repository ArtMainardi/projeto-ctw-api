package com.ctw.projeto_ctw.mrsc.controller;

import com.ctw.projeto_ctw.mrsc.model.Turmas;
import com.ctw.projeto_ctw.mrsc.service.TurmasService;
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
    public List<Turmas> listar(){ return service.listar(); }

    @GetMapping("/rank")
    public List<Turmas> ranqueamento(){
        return service.rank();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turmas> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Turmas> salvar(@RequestBody Turmas newTurma){
        return ResponseEntity.ok(service.salvar(newTurma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turmas> modificar(@RequestBody Turmas modifiedTurma, @PathVariable Long id){
        return ResponseEntity.ok(service.modificar(modifiedTurma, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
