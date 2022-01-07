package com.joabepereira.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joabepereira.financas.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
