package com.hgn.finchhamburgueria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hgn.finchhamburgueria.domain.Ingrediente;
import com.hgn.finchhamburgueria.repositories.IngredienteRepository;

@RestController
@RequestMapping(value = "/ingredientes")
public class IngredienteController {

	@Autowired
	private IngredienteRepository ingredienteRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Ingrediente> findAll() {
		return ingredienteRepository.findAll();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Ingrediente findIngredienteById(@PathVariable Long id) {
		return ingredienteRepository.findIngredienteById(id);
	}

	@RequestMapping(path = "nome/{nome}", method = RequestMethod.GET)
	public Ingrediente findIngregredienteByNome(@PathVariable String nome) {
		return ingredienteRepository.findIngregredienteByNome(nome);
	}

}
