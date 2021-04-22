package com.hgn.finchhamburgueria.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.hgn.finchhamburgueria.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgn.finchhamburgueria.DTO.NovoLancheDTO;
import com.hgn.finchhamburgueria.domain.Ingrediente;
import com.hgn.finchhamburgueria.domain.Lanche;
import com.hgn.finchhamburgueria.exceptionhandler.NegocioException;
import com.hgn.finchhamburgueria.repositories.IngredienteRepository;
import com.hgn.finchhamburgueria.repositories.LancheRepository;

@Service
public class LancheService {

	@Autowired
	private LancheRepository lancheRepository;

	@Autowired
	private IngredienteRepository ingredienteRepository;

	public List<Lanche> listarTodos() {
		return lancheRepository.findAll();
	}

	public Lanche buscarPorId(Integer id) {
		Optional<Lanche> optionalLanche = lancheRepository.findById(id);
		if (optionalLanche != null) {
			Lanche lanche = optionalLanche.get();
			return lanche;
		}
		throw new NegocioException("Lanche não cadastrado.");
	}

	public Lanche buscarPorNome(String nome) {
		Lanche lanche = lancheRepository.findLancheByNome(nome);
		if (lanche.getNome() != null) {
			return lanche;
		} else {
			throw new NegocioException("Lanche não cadastrado");
		}
	}

	public Lanche salvar(Lanche lanche) {
		return lancheRepository.save(lanche);
	}

//	public Lanche salvarLanche(Lanche lanche) {
//		return lancheRepository.save(lanche);
//	}
//	public Lanche novoLanche(NovoLancheDTO novoLanche) {
//		Lanche lanche = new Lanche(null, novoLanche.getNome(), novoLanche.getPreco());
//		Ingrediente ingrediente1 = ingredienteRepository.findIngredienteById(novoLanche.getIngrediente1id());
//		Ingrediente ingrediente2 = ingredienteRepository.findIngredienteById(novoLanche.getIngrediente2id());
//		Ingrediente ingrediente3 = ingredienteRepository.findIngredienteById(novoLanche.getIngrediente3id());
//		Ingrediente ingrediente4 = ingredienteRepository.findIngredienteById(novoLanche.getIngrediente4id());
//		Ingrediente ingrediente5 = ingredienteRepository.findIngredienteById(novoLanche.getIngrediente5id());
//		lanche.getIngredientes().add(ingrediente1);
//		lanche.getIngredientes().add(ingrediente2);
//		lanche.getIngredientes().add(ingrediente3);
//		lanche.getIngredientes().add(ingrediente4);
//		lanche.getIngredientes().add(ingrediente5);
//		return lanche;
//	}

	public void apagar(Lanche lanche) {
		if (!lancheRepository.existsById(lanche.getId())) {
			throw new NegocioException("Lanche não encontrado para deletar.");
		}
		lancheRepository.deleteById(lanche.getId());
		return;
	}
}
