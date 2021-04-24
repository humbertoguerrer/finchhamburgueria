package com.hgn.finchhamburgueria.services;

import com.hgn.finchhamburgueria.DTO.PedidoLancheCardapioDTO;
import com.hgn.finchhamburgueria.DTO.PedidoNovoLancheDTO;
import com.hgn.finchhamburgueria.domain.Cliente;
import com.hgn.finchhamburgueria.domain.Ingrediente;
import com.hgn.finchhamburgueria.domain.Lanche;
import com.hgn.finchhamburgueria.domain.Pedido;
import com.hgn.finchhamburgueria.exceptionhandler.NegocioException;
import com.hgn.finchhamburgueria.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

  @Autowired private PedidoRepository pedidoRepository;

  @Autowired private ClienteService clienteService;

  @Autowired private IngredienteService ingredienteService;

  @Autowired private LancheService lancheService;

  public Pedido buscarPorId(Integer id) {
    Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
    if (optionalPedido != null) {
      Pedido pedido = optionalPedido.get();
      return pedido;
    }
    throw new NegocioException("Pedido não cadastrado.");
  }

  public Pedido buscarPorNome(String nome) {
    Pedido pedido = pedidoRepository.findPedidoByCliente(nome);
    if (pedido.getCliente().getNome() != null) {
      return pedido;
    } else {
      throw new NegocioException("Pedido não cadastrado.");
    }
  }

  public Pedido salvarPedido(Pedido pedido) {
    return pedidoRepository.save(pedido);
  }

  public Pedido cardapioDTO(PedidoLancheCardapioDTO pedidoCardapioDTO) {
    Cliente cliente = clienteService.buscarPorId(pedidoCardapioDTO.getClienteId());
    Pedido pedido = new Pedido(null, cliente);
    for (Integer lancheId : pedidoCardapioDTO.getLanchesId()) {
      Lanche lanche = lancheService.buscarPorId(lancheId);
      pedido.getLanches().add(lanche);
    }
    return pedido;
  }

  public Pedido novoLancheDTO(PedidoNovoLancheDTO pedidoNovoLancheDTO) {
    Cliente cliente = clienteService.buscarPorId(pedidoNovoLancheDTO.getClienteId());
    Lanche lanche = new Lanche(null, null);
    lancheService.salvar(lanche);
    for (Integer ingredienteId : pedidoNovoLancheDTO.getIngredientesId()) {
      Ingrediente ingrediente = ingredienteService.buscarPorId(ingredienteId);
      lanche.getIngredientes().add(ingrediente);
    }
    Pedido pedido = new Pedido(null, cliente);
    pedido.getLanches().add(lanche);
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
