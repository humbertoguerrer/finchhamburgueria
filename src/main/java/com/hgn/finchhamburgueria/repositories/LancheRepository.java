package com.hgn.finchhamburgueria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hgn.finchhamburgueria.domain.Lanche;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, String>{
	
	Lanche findLancheById(Long id);
	
	Lanche findLancheByNome(String nome);

}
