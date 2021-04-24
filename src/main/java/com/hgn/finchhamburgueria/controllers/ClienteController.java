package com.hgn.finchhamburgueria.controllers;

import com.hgn.finchhamburgueria.domain.Cliente;
import com.hgn.finchhamburgueria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

  @Autowired private ClienteService clienteService;

  @RequestMapping(method = RequestMethod.GET)
  public List<Cliente> findAll() {
    return clienteService.listarTodos();
  }

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
  public ResponseEntity<Cliente> atualizar(
      @Valid @PathVariable Integer id, @RequestBody Cliente cliente) {
    clienteService.atualizar(cliente);
    return ResponseEntity.ok(cliente);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> apagar(@PathVariable Integer id) {
    clienteService.apagar(id);
    return ResponseEntity.noContent().build();
  }
}
