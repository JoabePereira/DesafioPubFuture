package com.joabepereira.financas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joabepereira.financas.entities.Conta;
import com.joabepereira.financas.entities.Despesa;
import com.joabepereira.financas.repositories.ContaRepository;
import com.joabepereira.financas.repositories.DespesaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private DespesaRepository despesaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Conta conta1 = new Conta(null, 2.000, "Conta Corrente", "Banco Inter");
		Conta conta2 = new Conta(null, 3.000, "Conta Corrente", "Banco C6");
		
		Despesa despesa1 = new Despesa(null, 50.00, "07/01/2022", "07/01/2022", "Transporte", conta1);
		Despesa despesa2 = new Despesa(null, 500.00, "07/01/2022", "07/01/2022", "Educação", conta2);
		Despesa despesa3 = new Despesa(null, 800.00, "07/01/2022", "07/01/2022", "Moradia", conta2);
		Despesa despesa4 = new Despesa(null, 600.00, "07/01/2022", "07/01/2022", "Lazer", conta1);
		
		contaRepository.saveAll(Arrays.asList(conta1, conta2));
		despesaRepository.saveAll(Arrays.asList(despesa1, despesa2, despesa3, despesa4));
		
	}

}
