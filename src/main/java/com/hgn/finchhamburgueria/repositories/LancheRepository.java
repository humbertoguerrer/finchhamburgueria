package com.hgn.finchhamburgueria.repositories;

import com.hgn.finchhamburgueria.domain.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, Integer> {

  Lanche findLancheByNome(String nome);
}
