package com.joabepereira.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joabepereira.financas.entities.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}
