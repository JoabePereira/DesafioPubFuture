package com.joabepereira.financas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joabepereira.financas.entities.Receita;
import com.joabepereira.financas.repositories.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository; 
	
	public List<Receita> findAll() {
		return receitaRepository.findAll();
	}
	
	public Receita insert(Receita receita) {
		return receitaRepository.save(receita);
	}
	
	public void delete(Long id) {
		receitaRepository.deleteById(id);
	}
}
