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
}
