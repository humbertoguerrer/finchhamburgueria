package com.hgn.finchhamburgueria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hgn.finchhamburgueria.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String>{

}
