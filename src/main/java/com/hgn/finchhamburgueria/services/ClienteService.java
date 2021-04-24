package com.hgn.finchhamburgueria.services;

import com.hgn.finchhamburgueria.domain.Cliente;
import com.hgn.finchhamburgueria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

  @Autowired private ClienteRepository clienteRepository;

  public List<Cliente> listarTodos() {
    return clienteRepository.findAll();
  }

  public Cliente buscarPorId(Integer id) {
    Optional<Cliente> optionalCliente = clienteRepository.findById(id);
    Cliente cliente = optionalCliente.get();
    cliente.setConta(cliente.getPedidos());
    return cliente;
  }

  public Cliente buscarPorNome(String nome) {
    Cliente cliente = clienteRepository.findClienteByNome(nome);
    cliente.setConta(cliente.getPedidos());
    return cliente;
  }

  public Cliente salvar(Cliente cliente) {
    cliente.setConta(cliente.getPedidos());
    return clienteRepository.save(cliente);
  }

  public Cliente atualizar(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  public void apagar(Integer id) {
    clienteRepository.deleteById(id);
    return;
  }
}
