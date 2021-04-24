package com.hgn.finchhamburgueria.controllers;

import com.hgn.finchhamburgueria.DTO.PedidoLancheCardapioDTO;
import com.hgn.finchhamburgueria.DTO.PedidoNovoLancheDTO;
import com.hgn.finchhamburgueria.domain.Pedido;
import com.hgn.finchhamburgueria.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

  @Autowired private PedidoService pedidoService;

  @RequestMapping(method = RequestMethod.GET)
  public List<Pedido> listarTodos() {
    return pedidoService.listarTodos();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Pedido> buscar(@PathVariable Integer id) {
    Pedido pedido = pedidoService.buscarPorId(id);
    return ResponseEntity.ok().body(pedido);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Pedido salvar(@RequestBody PedidoLancheCardapioDTO pedidoCardapioDTO) {
    Pedido pedido = pedidoService.cardapioDTO(pedidoCardapioDTO);
    return pedidoService.salvarPedido(pedido);
  }

    @RequestMapping(value = "/novoLanche", method = RequestMethod.POST)
  	@ResponseStatus(HttpStatus.CREATED)
  	public Pedido salvar(@RequestBody PedidoNovoLancheDTO pedidoNovoLancheDTO) {
  		Pedido pedido = pedidoService.novoLancheDTO(pedidoNovoLancheDTO);
  		return pedidoService.salvarPedido(pedido);
  	}

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> apagar(@PathVariable Integer id) {
    pedidoService.apagar(id);
    return ResponseEntity.noContent().build();
  }
}
