package com.ctw.projeto_ctw.materia.service;

import com.ctw.projeto_ctw.materia.model.Materia;
import com.ctw.projeto_ctw.materia.repository.MateriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MateriaService {
    private final MateriaRepository repository;

    public List<Materia> listar(){
        return repository.findAll();
    }
    public Materia buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Matéria não encontrada!"));
    }
    public Materia salvar(Materia mat){
        return repository.save(mat);
    }
    public Materia atualizar(Long id, Materia mat){
        Materia mod = buscarPorId(id);
        mod.setNome_materia(mat.getNome_materia());
        return repository.save(mod);
    }
    public void excluir(Long id){
        repository.deleteById(id);
    }
}
