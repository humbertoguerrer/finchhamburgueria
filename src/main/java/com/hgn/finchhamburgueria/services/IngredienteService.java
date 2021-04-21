package com.hgn.finchhamburgueria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgn.finchhamburgueria.domain.Ingrediente;
import com.hgn.finchhamburgueria.exceptionhandler.NegocioException;
import com.hgn.finchhamburgueria.repositories.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	private IngredienteRepository ingredienteRepository;

	public List<Ingrediente> listarTodos() {
		return ingredienteRepository.findAll();
	}

	public Ingrediente buscarPorId(Integer id) {
		Optional<Ingrediente> optionalIngrediente = ingredienteRepository.findById(id);
		if (optionalIngrediente != null) {
			Ingrediente ingrediente = optionalIngrediente.get();
			return ingrediente;
		}
		throw new NegocioException("Ingrediente não cadastrado.");
	}

	public Ingrediente buscarPorNome(String nome) {
		Ingrediente ingrediente = ingredienteRepository.findIngredienteByNome(nome);
		if (ingrediente.getNome() != null) {
			return ingrediente;
		} else {
			throw new NegocioException("Lanche não cadastrado");
		}
	}

	public Ingrediente salvarIngrediente(Ingrediente ingrediente) {
		return ingredienteRepository.save(ingrediente);
	}

	public Ingrediente atualizar(Ingrediente ingrediente) {
		if (!ingredienteRepository.existsById(ingrediente.getId())) {
			throw new NegocioException("Ingrediente não encontrado para atualização.");
		}
		return ingredienteRepository.save(ingrediente);
	}

	public void apagarIngrediente(Ingrediente ingrediente) {
		if (!ingredienteRepository.existsById(ingrediente.getId())) {
			throw new NegocioException("Ingrediente não encontrado para deletar.");
		}
		ingredienteRepository.deleteById(ingrediente.getId());
		return;
	}
}
