package com.hgn.finchhamburgueria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hgn.finchhamburgueria.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
