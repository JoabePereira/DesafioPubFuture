package com.joabepereira.financas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joabepereira.financas.entities.Conta;
import com.joabepereira.financas.repositories.ContaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ContaRepository contaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Conta conta1 = new Conta(null, 2.000, "Conta Corrente", "Banco Inter");
		Conta conta2 = new Conta(null, 3.000, "Conta Corrente", "Banco C6");
		
		contaRepository.saveAll(Arrays.asList(conta1, conta2));
		
	}

}
