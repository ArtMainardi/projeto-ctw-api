package com.ctw.projeto_ctw.professoresMaterias.service;

import com.ctw.projeto_ctw.materias.model.Materias;
import com.ctw.projeto_ctw.materias.service.MateriasService;
import com.ctw.projeto_ctw.professores.model.Professores;
import com.ctw.projeto_ctw.professores.service.ProfessoresService;
import com.ctw.projeto_ctw.professoresMaterias.model.ProfessoresMaterias;
import com.ctw.projeto_ctw.professoresMaterias.repository.ProfessoresMateriasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessoresMateriasService {
    private final ProfessoresMateriasRepository repository;
    private final ProfessoresService profService;
    private final MateriasService matService;

    public List<ProfessoresMaterias> listar(){
        return repository.findAll();
    }

    public ProfessoresMaterias buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Relacionamento entre tal professor e tal matéria é inexistente!"));
    }

    public ProfessoresMaterias salvar(Long id_professor, Long id_materia){
        ProfessoresMaterias profMat = new ProfessoresMaterias(null, profService.buscarPorId(id_professor), matService.buscarPorId(id_materia));
        Professores prof = profService.buscarPorId(id_professor);
        List<ProfessoresMaterias> relProf = prof.getProfMat();
        relProf.add(profMat);
        prof.setProfMat(relProf);
        profService.atualizar(id_professor, prof);
        profMat.setProfessor(prof);
        Materias mat = matService.buscarPorId(id_materia);
        List<ProfessoresMaterias> relMat = mat.getProfMat();
        relMat.add(profMat);
        mat.setProfMat(relMat);
        matService.atualizar(id_materia, mat);
        profMat.setMateria(mat);
        return repository.save(profMat);
    }

    public ProfessoresMaterias atualizar(ProfessoresMaterias profMat, Long id){
        ProfessoresMaterias mod = buscarPorId(id);
        mod.setProfessor(profMat.getProfessor());
        mod.setMateria(profMat.getMateria());
        return repository.save(mod);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }
}
