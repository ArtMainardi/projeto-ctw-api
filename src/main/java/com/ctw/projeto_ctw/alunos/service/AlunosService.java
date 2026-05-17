package com.ctw.projeto_ctw.alunos.service;

import com.ctw.projeto_ctw.alunos.model.Alunos;
import com.ctw.projeto_ctw.alunos.repository.AlunosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AlunosService {
    private final AlunosRepository repository;

    // Listar todos os dados:
    public List<Alunos> listar(){ return repository.findAll(); }

    // Buscar por ID:
    public Alunos buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));
    }

    // Salvar:
    public Alunos salvar(Alunos newAluno){ return repository.save(newAluno); }

    // Modificar:
    public Alunos modificar(Alunos modifiedAluno, Long id){
        Alunos newAluno = buscar(id);
        newAluno.setNome_aluno(modifiedAluno.getNome_aluno());
        newAluno.setMatricula_aluno(modifiedAluno.getMatricula_aluno());
        newAluno.setData_nascimento_aluno(modifiedAluno.getData_nascimento_aluno());
        newAluno.setCpf_aluno(modifiedAluno.getCpf_aluno());
        newAluno.setTurma(modifiedAluno.getTurma());
        newAluno.setFoto_perfil_aluno(modifiedAluno.getFoto_perfil_aluno());
        newAluno.setEmail_aluno(modifiedAluno.getEmail_aluno());
        newAluno.setSenha_aluno(modifiedAluno.getSenha_aluno());
        newAluno.setData_criacao_aluno(modifiedAluno.getData_criacao_aluno());
        return repository.save(newAluno);
    }

    // Deletar:
    public void deletar(Long id){
        repository.deleteById(id);
    }
}
