package com.joabepereira.financas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joabepereira.financas.entities.Despesa;
import com.joabepereira.financas.repositories.DespesaRepository;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository despesaRepository; 
	
	public List<Despesa> findAll() {
		return despesaRepository.findAll();
	}
	
	public Despesa insert(Despesa despesa) {
		return despesaRepository.save(despesa);
	}
	
	public void delete(Long id) {
		despesaRepository.deleteById(id);
	}
	
	public Despesa update(Long id, Despesa despesa) {
		Despesa entity = despesaRepository.getById(id);
		updateDespesa(entity, despesa);
		return despesaRepository.save(entity);
	}

	private void updateDespesa(Despesa entity, Despesa despesa) {
		entity.setValor(despesa.getValor());
		entity.setTipoDespesa(despesa.getTipoDespesa());
		entity.setDataPagamento(despesa.getDataPagamento());
		entity.setDataPagamentoEsperado(despesa.getDataPagamentoEsperado());
		entity.setConta(despesa.getConta());
	}
}
