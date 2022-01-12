package com.joabepereira.financas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joabepereira.financas.entities.Receita;
import com.joabepereira.financas.services.ReceitaService;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaResource {
	
	@Autowired
	private ReceitaService receitaService;
	
	@GetMapping
	public ResponseEntity<List<Receita>> findAll() {
		List<Receita> list = receitaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Receita> insert(@RequestBody Receita receita) {
		receita = receitaService.insert(receita);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(receita.getId()).toUri();
		return ResponseEntity.created(uri).body(receita);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		receitaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Receita> update(@PathVariable Long id, @RequestBody Receita receita) {
		receita = receitaService.update(id, receita);
		return ResponseEntity.ok().body(receita);
	}
}
