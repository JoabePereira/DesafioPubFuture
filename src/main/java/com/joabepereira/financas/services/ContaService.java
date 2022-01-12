package com.joabepereira.financas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joabepereira.financas.entities.Conta;
import com.joabepereira.financas.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository; 
	
	public List<Conta> findAll() {
		return contaRepository.findAll();
	}
	
	public Conta insert(Conta conta) {
		return contaRepository.save(conta);
	}
	
	public void delete(Long id) {
		contaRepository.deleteById(id);
	}
	
	public Conta update(Long id, Conta conta) {
		Conta entity = contaRepository.getById(id);
		updateConta(entity, conta);
		return contaRepository.save(entity);
	}

	private void updateConta(Conta entity, Conta conta) {
		entity.setSaldo(conta.getSaldo());
	}
}
