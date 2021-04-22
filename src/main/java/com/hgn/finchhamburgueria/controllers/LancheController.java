package com.hgn.finchhamburgueria.controllers;

import java.util.List;

import javax.validation.Valid;

import com.hgn.finchhamburgueria.domain.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hgn.finchhamburgueria.DTO.NovoLancheDTO;
import com.hgn.finchhamburgueria.domain.Lanche;
import com.hgn.finchhamburgueria.services.LancheService;

@RestController
@RequestMapping(value = "/lanches")
public class LancheController {

	@Autowired
	private LancheService lancheService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Lanche> findAll() {
		return lancheService.listarTodos();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Lanche> buscar(@PathVariable Integer id) {
		Lanche lanche = lancheService.buscarPorId(id);
		return ResponseEntity.ok().body(lanche);
	}

	@RequestMapping(value = "nome/{nome}", method = RequestMethod.GET)
	public Lanche buscarLancheNome(@PathVariable String nome) {
		return lancheService.buscarPorNome(nome);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Lanche salvar(@Valid @RequestBody Lanche lanche) {
		return lancheService.salvar(lanche);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagarLanche(@PathVariable Integer id) {
		return ResponseEntity.noContent().build();
	}
}
