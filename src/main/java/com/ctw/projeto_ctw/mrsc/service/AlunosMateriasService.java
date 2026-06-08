package com.ctw.projeto_ctw.mrsc.service;

import com.ctw.projeto_ctw.mrsc.model.AlunosMaterias;
import com.ctw.projeto_ctw.mrsc.repository.AlunosMateriasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunosMateriasService {

    private final AlunosMateriasRepository repository;
    private final AlunosService alnService;
    private final MateriasService matService;

    public List<AlunosMaterias> listar(){
        return repository.findAll();
    }

    public AlunosMaterias buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Relacionamento entre tal aluno e matéria é inexistente!"));
    }

    public AlunosMaterias salvar(Long id_aluno, Long id_materia){
        return repository.save(new AlunosMaterias(null, matService.buscarPorId(id_materia), alnService.buscar(id_aluno)));
    }

    public AlunosMaterias atualizar(AlunosMaterias alnMat, Long id){
        AlunosMaterias mod = buscarPorId(id);
        mod.setMateria(alnMat.getMateria());
        mod.setAluno(alnMat.getAluno());
        return repository.save(mod);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }
}
