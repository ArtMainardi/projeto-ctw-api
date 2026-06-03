package com.ctw.projeto_ctw.materias.service;

import com.ctw.projeto_ctw.materias.model.Materias;
import com.ctw.projeto_ctw.materias.repository.MateriasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MateriasService {
    private final MateriasRepository repository;

    public List<Materias> listar(){
        return repository.findAll();
    }
    public Materias buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Matéria não encontrada!"));
    }
    public Materias salvar(Materias mat){
        return repository.save(mat);
    }
    public Materias atualizar(Long id, Materias mat){
        Materias mod = buscarPorId(id);
        mod.setNome_materia(mat.getNome_materia());
        return repository.save(mod);
    }
    public void excluir(Long id){
        repository.deleteById(id);
    }
}
