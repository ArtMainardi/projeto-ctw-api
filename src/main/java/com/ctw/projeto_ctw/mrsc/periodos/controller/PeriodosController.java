package com.ctw.projeto_ctw.mrsc.periodos.controller;

import com.ctw.projeto_ctw.mrsc.periodos.model.Periodos;
import com.ctw.projeto_ctw.mrsc.periodos.service.PeriodosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periodos")
@RequiredArgsConstructor
@CrossOrigin("*")

public class PeriodosController {
    private final PeriodosService service;

    @GetMapping
    public List<Periodos> listar(){ return service.listar(); }
    // --
    @GetMapping("/{id}")
    public ResponseEntity<Periodos> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }
    // --
    @PostMapping
    public ResponseEntity<Periodos> salvar(@RequestBody Periodos newPeriodo){
        return ResponseEntity.ok(service.salvar(newPeriodo));
    }
    // --
    @PutMapping("/{id}")
    public ResponseEntity<Periodos> modificar(@RequestBody Periodos modifiedPeriodo, @PathVariable Long id){
        return ResponseEntity.ok(service.modificar(modifiedPeriodo, id));
    }
    // --
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
