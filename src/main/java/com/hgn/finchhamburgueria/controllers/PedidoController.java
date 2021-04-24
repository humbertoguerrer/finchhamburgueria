package com.hgn.finchhamburgueria.controllers;

import java.sql.PreparedStatement;
import java.util.List;

import javax.validation.Valid;

import com.hgn.finchhamburgueria.DTO.PedidoLancheCardapioDTO;
import com.hgn.finchhamburgueria.DTO.PedidoNovoLancheDTO;
import com.hgn.finchhamburgueria.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hgn.finchhamburgueria.DTO.NovoPedidoDTO;
import com.hgn.finchhamburgueria.domain.Pedido;
import com.hgn.finchhamburgueria.repositories.PedidoRepository;
import com.hgn.finchhamburgueria.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

  @Autowired private PedidoRepository pedidoRepository;

  @Autowired private PedidoService pedidoService;

  public List<Pedido> listarTodos() {
    return pedidoRepository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Pedido> buscar(@PathVariable Integer id) {
    Pedido pedido = pedidoService.buscarPorId(id);
    return ResponseEntity.ok().body(pedido);
  }

  @RequestMapping(path = "pedidoCliente/{nome}", method = RequestMethod.GET)
  public Pedido buscarPedidoCliente(@PathVariable String nome) {
    return pedidoService.buscarPorNome(nome);
  }

//  @PostMapping
//  @ResponseStatus(HttpStatus.CREATED)
//  public Pedido salvar(@Valid @RequestBody Pedido pedido) {
//    return pedidoService.salvarPedido(pedido);
//  }

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
  public ResponseEntity<Void> apagarPedido(@PathVariable Integer id) {
    return ResponseEntity.noContent().build();
  }
}
