package com.hgn.finchhamburgueria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hgn.finchhamburgueria.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	Cliente findClienteByNome(String nome);

	boolean existsById(Integer id);

}
