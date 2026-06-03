package com.ctw.projeto_ctw.professorMateria.controller;

import com.ctw.projeto_ctw.professorMateria.model.ProfessorMateria;
import com.ctw.projeto_ctw.professorMateria.service.ProfessorMateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor-materia")
@RequiredArgsConstructor
public class ProfessorMateriaController {

    private final ProfessorMateriaService service;

    @GetMapping
    public List<ProfessorMateria> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorMateria> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/professor/{id_professor}/materia/{id_materia}")
    public ResponseEntity<ProfessorMateria> salvar(@PathVariable Long id_professor, @PathVariable Long id_materia){
        return ResponseEntity.ok(service.salvar(id_professor, id_materia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorMateria> atualizar(@PathVariable Long id, @RequestBody ProfessorMateria profMat){
        return ResponseEntity.ok(service.atualizar(profMat, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
