package com.ctw.projeto_ctw.mrsc.conteudos.service;

import com.ctw.projeto_ctw.mrsc.conteudos.model.Conteudos;
import com.ctw.projeto_ctw.mrsc.conteudos.repository.ConteudosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ConteudosService {
    private final ConteudosRepository repository;

    // Listar todos os dados:
    public List<Conteudos> listar(){ return repository.findAll(); }

    // Buscar um id:
    public Conteudos buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Conteúdo não encontrado!"));
    }

    // Salvar um dado:
    public Conteudos salvar(Conteudos newConteudo){ return repository.save(newConteudo); }

    // Modificar um dado:
    public Conteudos modificar(Conteudos modifiedConteudo, Long id){
        Conteudos newConteudo = buscar(id);
        newConteudo.setTitulo_conteudo(modifiedConteudo.getTitulo_conteudo());
        newConteudo.setDescricao_conteudo(modifiedConteudo.getDescricao_conteudo());
        return repository.save(newConteudo);
    }

    // Deletar um dado:
    public void deletar(Long id){ repository.deleteById(id); }
}
