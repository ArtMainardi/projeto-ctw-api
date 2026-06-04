package com.ctw.projeto_ctw.mrsc.professores.controller;

import com.ctw.projeto_ctw.mrsc.professores.model.Professores;
import com.ctw.projeto_ctw.mrsc.professores.service.ProfessoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessoresController {
    private final ProfessoresService service;

    @GetMapping
    public List<Professores> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professores> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Professores> salvar(@RequestBody Professores prof){
        return ResponseEntity.ok(service.salvar(prof));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professores> atualizar(@PathVariable Long id, @RequestBody Professores prof){
        return ResponseEntity.ok(service.atualizar(id, prof));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
