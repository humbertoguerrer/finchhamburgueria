package com.hgn.finchhamburgueria.services;

import com.hgn.finchhamburgueria.domain.Lanche;
import com.hgn.finchhamburgueria.exceptionhandler.NegocioException;
import com.hgn.finchhamburgueria.repositories.IngredienteRepository;
import com.hgn.finchhamburgueria.repositories.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


	public Lanche atualizar(Lanche lanche) {
		if (!lancheRepository.existsById(lanche.getId())) {
			throw new NegocioException("Ingrediente não encontrado para atualização.");
		}
		return lancheRepository.save(lanche);
	}


	public void apagar(Lanche lanche) {
		if (!lancheRepository.existsById(lanche.getId())) {
			throw new NegocioException("Lanche não encontrado para deletar.");
		}
		lancheRepository.deleteById(lanche.getId());
		return;
	}
}
