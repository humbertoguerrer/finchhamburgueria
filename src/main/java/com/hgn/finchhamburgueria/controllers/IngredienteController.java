package com.hgn.finchhamburgueria.controllers;

import com.hgn.finchhamburgueria.domain.Ingrediente;
import com.hgn.finchhamburgueria.services.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    ingredienteService.apagar(id);
    return ResponseEntity.noContent().build();
  }
}
