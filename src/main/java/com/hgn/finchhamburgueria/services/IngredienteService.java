package com.hgn.finchhamburgueria.services;

import com.hgn.finchhamburgueria.domain.Ingrediente;
import com.hgn.finchhamburgueria.repositories.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {

  @Autowired private IngredienteRepository ingredienteRepository;

  public List<Ingrediente> listarTodos() {
    return ingredienteRepository.findAll();
  }

  public Ingrediente buscarPorId(Integer id) {
    Optional<Ingrediente> optionalIngrediente = ingredienteRepository.findById(id);
    Ingrediente ingrediente = optionalIngrediente.get();
    return ingrediente;
  }

  public Ingrediente buscarPorNome(String nome) {
    Ingrediente ingrediente = ingredienteRepository.findIngredienteByNome(nome);
    return ingrediente;
  }

  public Ingrediente salvarIngrediente(Ingrediente ingrediente) {
    return ingredienteRepository.save(ingrediente);
  }

  public Ingrediente atualizar(Ingrediente ingrediente) {
    return ingredienteRepository.save(ingrediente);
  }

  public void apagar(Integer id) {
    ingredienteRepository.deleteById(id);
    return;
  }
}
