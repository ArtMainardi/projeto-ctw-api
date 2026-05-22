package com.example.demo.professor.service;

import com.example.demo.professor.model.Professor;
import com.example.demo.professor.repository.ProfessorRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository repository;

    public List<Professor> listar(){
        return repository.findAll();
    }
    public Professor buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Professor não encontrado!"));
    }
    public Professor salvar(Professor prof){
        return repository.save(prof);
    }
    public Professor atualizar(Long id, Professor prof){
        Professor mod = buscarPorId(id);
        mod.setNome_professor(prof.getNome_professor());
        mod.setCadastro_professor(prof.getCadastro_professor());
        mod.setCpf_professor(prof.getCpf_professor());
        mod.setEmail_professor(prof.getEmail_professor());
        mod.setEspecialidade_professor(mod.getEspecialidade_professor());
        mod.setSenha_professor(prof.getSenha_professor());
        mod.setData_criacao_professor(prof.getData_criacao_professor());
        mod.setData_nascimento_professor(prof.getData_nascimento_professor());
        mod.setFoto_perfil_professor(prof.getFoto_perfil_professor());
        return repository.save(mod);
    }
    public void excluir(Long id){
        repository.deleteById(id);
    }
}
