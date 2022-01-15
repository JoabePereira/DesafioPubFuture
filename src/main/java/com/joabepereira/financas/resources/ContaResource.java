package com.joabepereira.financas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joabepereira.financas.entities.Conta;
import com.joabepereira.financas.services.ContaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/contas")
@Api(value = "Finanças API REST")
@CrossOrigin(origins = "*")
public class ContaResource {
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping
	@ApiOperation(value = "Lista todas as contas")
	public ResponseEntity<List<Conta>> findAll() {
		List<Conta> list = contaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	@ApiOperation(value = "Salva uma conta")
	public ResponseEntity<Conta> insert(@RequestBody Conta conta) {
		conta = contaService.insert(conta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(conta.getId()).toUri();
		return ResponseEntity.created(uri).body(conta);
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Deleta uma conta")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		contaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Atualiza uma conta")
	public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta conta) {
		conta = contaService.update(id, conta);
		return ResponseEntity.ok().body(conta);
	}
}
