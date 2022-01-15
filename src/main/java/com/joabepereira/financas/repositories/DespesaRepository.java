package com.joabepereira.financas.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joabepereira.financas.entities.Despesa;
import com.joabepereira.financas.entities.enums.TipoDespesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
	
	public List<Despesa> findByDataPagamentoBetween(LocalDate dataInicial, LocalDate dataFinal);
	
	public List<Despesa> findByTipoDespesa(TipoDespesa tipoDespesa);

}
