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

import com.joabepereira.financas.entities.Despesa;
import com.joabepereira.financas.entities.enums.TipoDespesa;
import com.joabepereira.financas.services.DespesaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaResource {
	
	@Autowired
	private DespesaService despesaService;
	
	@GetMapping
	@ApiOperation(value = "Lista todas as despesas")
	public ResponseEntity<List<Despesa>> findAll() {
		List<Despesa> list = despesaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/data-pagamento")
	@ApiOperation(value = "Lista depesas por período")
	public ResponseEntity<List<Despesa>> despesaPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		List<Despesa> list = despesaService.despesaPorPeriodo(dataInicial, dataFinal);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/tipo-despesa")
	@ApiOperation(value = "Lista despesas por tipo")
	public ResponseEntity<List<Despesa>> consultarPorTipoDespesa(TipoDespesa tipoDespesa) {
		List<Despesa> list = despesaService.consultarPorTipoDespesa(tipoDespesa);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	@ApiOperation(value = "Salva uma despesa")
	public ResponseEntity<Despesa> insert(@RequestBody Despesa despesa) {
		despesa = despesaService.insert(despesa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(despesa.getId()).toUri();
		return ResponseEntity.created(uri).body(despesa);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma despesa")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		despesaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza uma despesa")
	public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody Despesa despesa) {
		despesa = despesaService.update(id, despesa);
		return ResponseEntity.ok().body(despesa);
	}
}
