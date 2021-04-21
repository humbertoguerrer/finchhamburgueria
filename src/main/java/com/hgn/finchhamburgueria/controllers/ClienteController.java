package com.hgn.finchhamburgueria.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hgn.finchhamburgueria.domain.Cliente;
import com.hgn.finchhamburgueria.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {
		Cliente cliente = clienteService.buscarPorId(id);
		return ResponseEntity.ok().body(cliente);
	}

	@RequestMapping(path = "nome/{nome}", method = RequestMethod.GET)
	public Cliente buscarClienteNome(@PathVariable String nome) {
		return clienteService.buscarPorNome(nome);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@Valid @RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Integer id, @RequestBody Cliente cliente) {
		clienteService.atualizar(cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id) {
		return ResponseEntity.noContent().build();
	}

}