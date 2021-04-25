package com.hgn.finchhamburgueria.services;

import com.hgn.finchhamburgueria.DTO.PedidoLancheCardapioDTO;
import com.hgn.finchhamburgueria.DTO.PedidoNovoLancheDTO;
import com.hgn.finchhamburgueria.domain.Cliente;
import com.hgn.finchhamburgueria.domain.Ingrediente;
import com.hgn.finchhamburgueria.domain.Lanche;
import com.hgn.finchhamburgueria.domain.Pedido;
import com.hgn.finchhamburgueria.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

  @Autowired private PedidoRepository pedidoRepository;

  @Autowired private ClienteService clienteService;

  @Autowired private IngredienteService ingredienteService;

  @Autowired private LancheService lancheService;

  public List<Pedido> listarTodos() {
    return pedidoRepository.findAll();
  }

  public Pedido buscarPorId(Integer id) {
    Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
    Pedido pedido = optionalPedido.get();
    return pedido;
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
    pedido.setPrecoPedido(pedido.getLanches());
    return pedido;
  }

  public Pedido novoLancheDTO(PedidoNovoLancheDTO pedidoNovoLancheDTO) {
    Cliente cliente = clienteService.buscarPorId(pedidoNovoLancheDTO.getClienteId());
    Lanche lanche = new Lanche(null, null);
    for (Integer ingredienteId : pedidoNovoLancheDTO.getIngredientesId()) {
      Ingrediente ingrediente = ingredienteService.buscarPorId(ingredienteId);
      lanche.getIngredientes().add(ingrediente);
    }
    lanche.setPreco(lanche.getIngredientes());
    lancheService.salvar(lanche);
    Pedido pedido = new Pedido(null, cliente);
    pedido.getLanches().add(lanche);
    pedido.setPrecoPedido(pedido.getLanches());
    return pedido;
  }

  public void apagar(Integer id) {
    pedidoRepository.deleteById(id);
    return;
  }
}
