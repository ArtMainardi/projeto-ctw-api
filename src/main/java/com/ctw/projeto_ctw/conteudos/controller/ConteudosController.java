package com.ctw.projeto_ctw.conteudos.controller;

import com.ctw.projeto_ctw.conteudos.model.Conteudos;
import com.ctw.projeto_ctw.conteudos.service.ConteudosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conteudos")
@RequiredArgsConstructor
@CrossOrigin("*")

public class ConteudosController {
    private final ConteudosService service;

    @GetMapping
    public List<Conteudos> listar(){ return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Conteudos> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Conteudos> salvar(@RequestBody Conteudos newConteudo){
        return ResponseEntity.ok(service.salvar(newConteudo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conteudos> modificar(@RequestBody Conteudos modifiedConteudo, @PathVariable Long id){
        return ResponseEntity.ok(service.modificar(modifiedConteudo, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
