package com.hgn.finchhamburgueria.services;

import com.hgn.finchhamburgueria.domain.Lanche;
import com.hgn.finchhamburgueria.repositories.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancheService {

  @Autowired private LancheRepository lancheRepository;

  public List<Lanche> listarTodos() {
    return lancheRepository.findAll();
  }

  public Lanche buscarPorId(Integer id) {
    Optional<Lanche> optionalLanche = lancheRepository.findById(id);
    Lanche lanche = optionalLanche.get();
    return lanche;
  }

  public Lanche buscarPorNome(String nome) {
    Lanche lanche = lancheRepository.findLancheByNome(nome);
    return lanche;
  }

  public Lanche salvar(Lanche lanche) {
    lanche.setPreco(lanche.getIngredientes());
    return lancheRepository.save(lanche);
  }

  public Lanche atualizar(Lanche lanche) {
    lanche.setPreco(lanche.getIngredientes());
    return lancheRepository.save(lanche);
  }

  public void apagar(Integer id) {
    lancheRepository.deleteById(id);
    return;
  }
}
