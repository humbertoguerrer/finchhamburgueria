package com.hgn.finchhamburgueria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hgn.finchhamburgueria.domain.Pedido;
import com.hgn.finchhamburgueria.repositories.PedidoRepository;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Pedido findPedidoById(@PathVariable Long id) {
		return pedidoRepository.findPedidoById(id);
	}
}
