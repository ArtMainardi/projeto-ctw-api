package com.example.demo.cardapio.controller;

import com.example.demo.cardapio.model.Cardapio;
import com.example.demo.cardapio.service.CardapioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
@RequiredArgsConstructor
public class CardapioController {
    private final CardapioService service;

    @GetMapping
    public List<Cardapio> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cardapio> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cardapio> salver(@RequestBody Cardapio card){
        return ResponseEntity.ok(service.salvar(card));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cardapio> atualizar(@PathVariable Long id, @RequestBody Cardapio card){
        return ResponseEntity.ok(service.atualizar(card, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
