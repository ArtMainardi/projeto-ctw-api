package com.ctw.projeto_ctw.mrsc.professoresMaterias.controller;

import com.ctw.projeto_ctw.mrsc.professoresMaterias.model.ProfessoresMaterias;
import com.ctw.projeto_ctw.mrsc.professoresMaterias.service.ProfessoresMateriasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor-materia")
@RequiredArgsConstructor
public class ProfessoresMateriasController {

    private final ProfessoresMateriasService service;

    @GetMapping
    public List<ProfessoresMaterias> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessoresMaterias> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/professor/{id_professor}/materia/{id_materia}")
    public ResponseEntity<ProfessoresMaterias> salvar(@PathVariable Long id_professor, @PathVariable Long id_materia){
        return ResponseEntity.ok(service.salvar(id_professor, id_materia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessoresMaterias> atualizar(@PathVariable Long id, @RequestBody ProfessoresMaterias profMat){
        return ResponseEntity.ok(service.atualizar(profMat, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
