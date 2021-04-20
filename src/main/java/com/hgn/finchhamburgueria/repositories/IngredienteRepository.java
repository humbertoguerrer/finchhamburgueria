package com.hgn.finchhamburgueria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hgn.finchhamburgueria.domain.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, String>{

}
