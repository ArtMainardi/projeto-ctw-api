package com.ctw.projeto_ctw.mrsc.professoresMaterias.service;

import com.ctw.projeto_ctw.mrsc.materias.service.MateriasService;
import com.ctw.projeto_ctw.mrsc.professores.service.ProfessoresService;
import com.ctw.projeto_ctw.mrsc.professoresMaterias.model.ProfessoresMaterias;
import com.ctw.projeto_ctw.mrsc.professoresMaterias.repository.ProfessoresMateriasRepository;
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
        return repository.save(new ProfessoresMaterias(null, profService.buscarPorId(id_professor), matService.buscarPorId(id_materia)));
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
