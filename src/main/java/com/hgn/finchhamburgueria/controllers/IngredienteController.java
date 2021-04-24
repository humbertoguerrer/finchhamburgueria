package com.hgn.finchhamburgueria.controllers;

import java.util.List;

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

import com.hgn.finchhamburgueria.domain.Ingrediente;
import com.hgn.finchhamburgueria.services.IngredienteService;

@RestController
@RequestMapping(value = "/ingredientes")
public class IngredienteController {

  @Autowired private IngredienteService ingredienteService;

  @RequestMapping(method = RequestMethod.GET)
  public List<Ingrediente> findAll() {
    return ingredienteService.listarTodos();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Ingrediente> buscar(@PathVariable Integer id) {
    Ingrediente ingrediente = ingredienteService.buscarPorId(id);
    return ResponseEntity.ok().body(ingrediente);
  }

  @RequestMapping(value = "nome/{nome}", method = RequestMethod.GET)
  public Ingrediente buscarIngredienteNome(@PathVariable String nome) {
    return ingredienteService.buscarPorNome(nome);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Ingrediente salvar(@Valid @RequestBody Ingrediente ingrediente) {
    return ingredienteService.salvarIngrediente(ingrediente);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Ingrediente> atualizar(
      @Valid @PathVariable Integer id, @RequestBody Ingrediente ingrediente) {
    ingredienteService.atualizar(ingrediente);
    return ResponseEntity.ok(ingrediente);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> apagar(@PathVariable Integer id) {
    return ResponseEntity.noContent().build();
  }
}
