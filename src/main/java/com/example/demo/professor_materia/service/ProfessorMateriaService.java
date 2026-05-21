/*package com.example.demo.professor_materia.service;

import com.example.demo.professor_materia.model.ProfessorMateria;
import com.example.demo.professor_materia.repository.ProfessorMateriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorMateriaService {
    private final ProfessorMateriaRepository repository;

    public List<ProfessorMateria> listar(){
        return repository.findAll();
    }

    public ProfessorMateria buscarPorId(Long id){
        return repository.findAllById(id);
    }

    public ProfessorMateria salvar(ProfessorMateria pm){
        return repository.save(pm);
    }

    public void excluir(Long id){

    }
}
*/