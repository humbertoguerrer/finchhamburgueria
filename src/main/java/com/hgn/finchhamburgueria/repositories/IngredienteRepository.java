package com.hgn.finchhamburgueria.repositories;

import com.hgn.finchhamburgueria.domain.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

  Ingrediente findIngredienteByNome(String nome);
}
