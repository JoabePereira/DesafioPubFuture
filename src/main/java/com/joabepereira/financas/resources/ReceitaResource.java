package com.joabepereira.financas.resources;

import java.net.URI;
import java.time.LocalDate;
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
import com.joabepereira.financas.entities.enums.TipoReceita;
import com.joabepereira.financas.services.ReceitaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaResource {
	
	@Autowired
	private ReceitaService receitaService;
	
	@GetMapping
	@ApiOperation(value = "Lista todas as receitas")
	public ResponseEntity<List<Receita>> findAll() {
		List<Receita> list = receitaService.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/data-recebimento")
	@ApiOperation(value = "Lista receitas por período")
	public ResponseEntity<List<Receita>> consultarPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		List<Receita> list = receitaService.consultarPorPeriodo(dataInicial, dataFinal);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/tipo-receita")
	@ApiOperation(value = "Lista receitas por tipo")
	public ResponseEntity<List<Receita>> consultarPorTipoReceita(TipoReceita tipoReceita) {
		List<Receita> list = receitaService.consultarPorTipoReceita(tipoReceita);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	@ApiOperation(value = "Salva uma receita")
	public ResponseEntity<Receita> insert(@RequestBody Receita receita) {
		receita = receitaService.insert(receita);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(receita.getId()).toUri();
		return ResponseEntity.created(uri).body(receita);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma receita")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		receitaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza uma receita")
	public ResponseEntity<Receita> update(@PathVariable Long id, @RequestBody Receita receita) {
		receita = receitaService.update(id, receita);
		return ResponseEntity.ok().body(receita);
	}
}
