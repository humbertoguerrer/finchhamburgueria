package com.hgn.finchhamburgueria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hgn.finchhamburgueria.domain.Lanche;
import com.hgn.finchhamburgueria.repositories.LancheRepository;

@RestController
@RequestMapping(value = "/lanches")
public class LancheController {

	@Autowired
	private LancheRepository lancheRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Lanche> findAll() {
		return lancheRepository.findAll();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Lanche findLancheById(@PathVariable Long id) {
		return lancheRepository.findLancheById(id);
	}

	@RequestMapping(path = "nome/{nome}", method = RequestMethod.GET)
	public Lanche findClientByNome(@PathVariable String nome) {
		return lancheRepository.findLancheByNome(nome);
	}

}
