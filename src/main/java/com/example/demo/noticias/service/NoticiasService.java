package com.example.demo.noticias.service;

import com.example.demo.cardapio.model.Cardapio;
import com.example.demo.noticias.model.Noticias;
import com.example.demo.noticias.repository.NoticiasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticiasService {
    private final NoticiasRepository repository;

    public List<Noticias> listar(){
        return repository.findAll();
    }

    public Noticias buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Notícia não encontrada!"));
    }

    public Noticias salvar(Noticias not){
        return repository.save(not);
    }

    public Noticias atualizar(Noticias dados, Long id){
        Noticias mod = buscarPorId(id);
        mod.setId_noticias(dados.getId_noticias());
        mod.setImagem_noticia(dados.getImagem_noticia());
        mod.setTexto_noticia(dados.getTexto_noticia());
        mod.setTitulo_noticia(dados.getTitulo_noticia());
        mod.setData_publicacao(dados.getData_publicacao());
        return repository.save(mod);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }
}
