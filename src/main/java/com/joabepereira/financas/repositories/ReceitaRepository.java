package com.joabepereira.financas.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joabepereira.financas.entities.Receita;
import com.joabepereira.financas.entities.enums.TipoReceita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
	
	public List<Receita> findByDataRecebimentoBetween(LocalDate dataInicial, LocalDate dataFinal);
	public List<Receita> findByTipoReceita(TipoReceita tipoReceita);
	
}
