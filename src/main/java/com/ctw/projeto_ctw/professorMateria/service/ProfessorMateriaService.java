package com.ctw.projeto_ctw.professorMateria.service;

import com.ctw.projeto_ctw.materia.model.Materia;
import com.ctw.projeto_ctw.materia.service.MateriaService;
import com.ctw.projeto_ctw.professor.model.Professor;
import com.ctw.projeto_ctw.professor.service.ProfessorService;
import com.ctw.projeto_ctw.professorMateria.model.ProfessorMateria;
import com.ctw.projeto_ctw.professorMateria.repository.ProfessorMateriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorMateriaService {
    private final ProfessorMateriaRepository repository;
    private final ProfessorService profService;
    private final MateriaService matService;

    public List<ProfessorMateria> listar(){
        return repository.findAll();
    }

    public ProfessorMateria buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Relacionamento entre tal professor e tal matéria é inexistente!"));
    }

    public ProfessorMateria salvar(Long id_professor, Long id_materia){
        ProfessorMateria profMat = new ProfessorMateria(null, profService.buscarPorId(id_professor), matService.buscarPorId(id_materia));
        Professor prof = profService.buscarPorId(id_professor);
        List<ProfessorMateria> relProf = prof.getProfMat();
        relProf.add(profMat);
        prof.setProfMat(relProf);
        profService.atualizar(id_professor, prof);
        profMat.setProfessor(prof);
        Materia mat = matService.buscarPorId(id_materia);
        List<ProfessorMateria> relMat = mat.getProfMat();
        relMat.add(profMat);
        mat.setProfMat(relMat);
        matService.atualizar(id_materia, mat);
        profMat.setMateria(mat);
        return repository.save(profMat);
    }

    public ProfessorMateria atualizar(ProfessorMateria profMat, Long id){
        ProfessorMateria mod = buscarPorId(id);
        mod.setProfessor(profMat.getProfessor());
        mod.setMateria(profMat.getMateria());
        return repository.save(mod);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }
}
