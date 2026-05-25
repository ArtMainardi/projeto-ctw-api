package com.example.demo.cardapio.service;

import com.example.demo.cardapio.model.Cardapio;
import com.example.demo.cardapio.repository.CardapioRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.ast.tree.cte.CteMaterialization;
import org.springframework.stereotype.Service;

import javax.smartcardio.Card;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardapioService {
    private final CardapioRepository repository;

    public List<Cardapio> listar(){
        return repository.findAll();
    }

    public Cardapio buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cardápio não encontrado!"));
    }

    public Cardapio salvar(Cardapio card){
        return repository.save(card);
    }

    public Cardapio atualizar(Cardapio dados, Long id){
        Cardapio mod = buscarPorId(id);
        mod.setData_refeicao(dados.getData_refeicao());
        mod.setDescricao_refeicao(dados.getDescricao_refeicao());
        mod.setTipo_refeicao(dados.getTipo_refeicao());
        return repository.save(mod);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }
}