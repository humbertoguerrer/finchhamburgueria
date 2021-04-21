package com.hgn.finchhamburgueria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hgn.finchhamburgueria.domain.Lanche;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, Integer>{
	
	Lanche findLancheById(Integer id);
	
	Lanche findLancheByNome(String nome);

}
