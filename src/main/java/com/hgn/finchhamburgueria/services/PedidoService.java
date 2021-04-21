package com.hgn.finchhamburgueria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgn.finchhamburgueria.DTO.NovoPedidoDTO;
import com.hgn.finchhamburgueria.domain.Cliente;
import com.hgn.finchhamburgueria.domain.Lanche;
import com.hgn.finchhamburgueria.domain.Pedido;
import com.hgn.finchhamburgueria.exceptionhandler.NegocioException;
import com.hgn.finchhamburgueria.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido buscarPorId(Integer id) {
		Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
		if (optionalPedido != null) {
			Pedido pedido = optionalPedido.get();
			return pedido;
		}
		throw new NegocioException("Pedido não cadastrado.");
	}

	public Pedido salvarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public Pedido novoPedido(NovoPedidoDTO novoPedido) {
		Cliente cliente = new Cliente(novoPedido.getClienteId(), null, null);
		Lanche lanche = new Lanche(novoPedido.getLancheId(), null, null);
		Pedido pedido = new Pedido(null, novoPedido.getPrecoPedido(), cliente, lanche);
		return pedido;

	}

	public void apagar(Pedido pedido) {
		if (!pedidoRepository.existsById(pedido.getId())) {
			throw new NegocioException("Pedido não encontrado para deletar.");
		}
		pedidoRepository.deleteById(pedido.getId());
		return;
	}

}
