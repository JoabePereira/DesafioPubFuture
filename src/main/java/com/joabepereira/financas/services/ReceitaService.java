package com.joabepereira.financas.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joabepereira.financas.entities.Receita;
import com.joabepereira.financas.entities.enums.TipoReceita;
import com.joabepereira.financas.repositories.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository; 
	
	public List<Receita> findAll() {
		return receitaRepository.findAll();
	}
	
	public List<Receita> consultarPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		return receitaRepository.findByDataRecebimentoBetween(dataInicial, dataFinal);
	}
	
	public List<Receita> consultarPorTipoReceita(TipoReceita tipoReceita) {
		return receitaRepository.findByTipoReceita(tipoReceita);
	}
 	
	public Receita insert(Receita receita) {
		return receitaRepository.save(receita);
	}
	
	public void delete(Long id) {
		receitaRepository.deleteById(id);
	}
	
	public Receita update(Long id, Receita receita) {
		Receita entity = receitaRepository.getById(id);
		updateReceita(entity, receita);
		return receitaRepository.save(entity);
	}

	private void updateReceita(Receita entity, Receita receita) {
		entity.setValor(receita.getValor());
		entity.setTipoReceita(receita.getTipoReceita());
		entity.setDescricao(receita.getDescricao());
		entity.setDataRecebimento(receita.getDataRecebimento());
		entity.setDataRecebimentoEsperado(receita.getDataRecebimentoEsperado());
		entity.setConta(receita.getConta());
	}
}
