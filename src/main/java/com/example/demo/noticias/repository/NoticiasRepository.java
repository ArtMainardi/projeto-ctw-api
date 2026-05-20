package com.example.demo.noticias.repository;

import com.example.demo.noticias.model.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiasRepository extends JpaRepository<Noticias, Long> {
}
