package com.example.demo.noticias.controller;

import com.example.demo.cardapio.model.Cardapio;
import com.example.demo.noticias.model.Noticias;
import com.example.demo.noticias.service.NoticiasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticias")
@RequiredArgsConstructor
public class NoticiasController {
    private final NoticiasService service;

    public List<Noticias> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticias> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Noticias> salver(@RequestBody Noticias not){
        return ResponseEntity.ok(service.salvar(not));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticias> atualizar(@PathVariable Long id, @RequestBody Noticias not){
        return ResponseEntity.ok(service.atualizar(not, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
