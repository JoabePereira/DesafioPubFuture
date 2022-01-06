package com.joabepereira.financas.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joabepereira.financas.entidades.Receitas;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitasResource {
	
	@GetMapping
	public ResponseEntity<Receitas> findAll() {
		Receitas r = new Receitas(1L, 100, "05/01/2022", "05/01/2022", "Salario", "Premio");
		return ResponseEntity.ok().body(r);
	}
}
