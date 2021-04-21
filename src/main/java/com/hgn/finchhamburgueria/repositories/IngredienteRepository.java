package com.hgn.finchhamburgueria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hgn.finchhamburgueria.domain.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer>{

	Ingrediente findIngredienteById(Integer id);
	
	Ingrediente findIngredienteByNome(String nome);

}
