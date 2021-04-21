package com.hgn.finchhamburgueria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgn.finchhamburgueria.domain.Cliente;
import com.hgn.finchhamburgueria.exceptionhandler.NegocioException;
import com.hgn.finchhamburgueria.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscarPorId(Integer id) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		if (optionalCliente != null) {
			Cliente cliente = optionalCliente.get();
			return cliente;
		}
		throw new NegocioException("Cliente não cadastrado.");
	}

	public Cliente buscarPorNome(String nome) {
		Cliente cliente = clienteRepository.findClienteByNome(nome);
		if (cliente.getNome() != null) {
			return cliente;
		} else {
			throw new NegocioException("Cliente não cadastrado.");
		}
	}

	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente atualizar(Cliente cliente) {
		if (!clienteRepository.existsById(cliente.getId())) {
			throw new NegocioException("Cliente não encontrado para atualização.");
		}
		return clienteRepository.save(cliente);
	}

	public void apagar(Cliente cliente) {
		if (!clienteRepository.existsById(cliente.getId())) {
			throw new NegocioException("Cliente não encontrado para deletar.");
		}
		clienteRepository.deleteById(cliente.getId());
		return;
	}
}
