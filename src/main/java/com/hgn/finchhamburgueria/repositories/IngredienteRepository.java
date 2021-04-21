package com.hgn.finchhamburgueria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hgn.finchhamburgueria.domain.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, String>{

	Ingrediente findIngredienteById(Long id);
	
	Ingrediente findIngregredienteByNome(String nome);
	
}
