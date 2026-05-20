package com.example.demo.cardapio.repository;

import com.example.demo.cardapio.model.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
}
