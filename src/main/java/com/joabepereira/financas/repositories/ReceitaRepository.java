package com.joabepereira.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joabepereira.financas.entities.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
