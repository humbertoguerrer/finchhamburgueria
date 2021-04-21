package com.hgn.finchhamburgueria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hgn.finchhamburgueria.domain.Cliente;
import com.hgn.finchhamburgueria.domain.Ingrediente;
import com.hgn.finchhamburgueria.domain.Lanche;
import com.hgn.finchhamburgueria.domain.Pedido;
import com.hgn.finchhamburgueria.repositories.ClienteRepository;
import com.hgn.finchhamburgueria.repositories.IngredienteRepository;
import com.hgn.finchhamburgueria.repositories.LancheRepository;
import com.hgn.finchhamburgueria.repositories.PedidoRepository;

@SpringBootApplication
public class FinchhamburgueriaApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private LancheRepository lancheRepository;

	@Autowired
	private IngredienteRepository ingredienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinchhamburgueriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Ingrediente alface = new Ingrediente(null, "alface", 0.40);
		Ingrediente bacon = new Ingrediente(null, "bacon", 2.00);
		Ingrediente carne = new Ingrediente(null, "carne", 0.80);
		Ingrediente ovo = new Ingrediente(null, "ovo", 0.40);
		Ingrediente queijo = new Ingrediente(null, "queijo", 1.50);

		ingredienteRepository.save(alface);
		ingredienteRepository.save(bacon);
		ingredienteRepository.save(carne);
		ingredienteRepository.save(ovo);
		ingredienteRepository.save(queijo);

		//////////////////////////////////////

		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(bacon);
		ingredientes.add(carne);
		ingredientes.add(queijo);

		Lanche xBacon = new Lanche(null, "xBacon");
		xBacon.setIngredientes(ingredientes);
		xBacon.setPreco(ingredientes);
		lancheRepository.save(xBacon);
		ingredientes.removeAll(ingredientes);

		//////////////////////////////////////

		ingredientes.add(carne);
		ingredientes.add(queijo);

		Lanche xBurguer = new Lanche(null, "xBurguer");
		xBacon.setIngredientes(ingredientes);
		xBurguer.setPreco(ingredientes);
		lancheRepository.save(xBurguer);
		ingredientes.removeAll(ingredientes);

		//////////////////////////////////////

		ingredientes.add(ovo);
		ingredientes.add(carne);
		ingredientes.add(queijo);
		Lanche xEgg = new Lanche(null, "xEgg");
		xEgg.setIngredientes(ingredientes);
		xEgg.setPreco(ingredientes);
		lancheRepository.save(xEgg);
		ingredientes.removeAll(ingredientes);

		//////////////////////////////////////

		ingredientes.add(ovo);
		ingredientes.add(bacon);
		ingredientes.add(carne);
		ingredientes.add(queijo);
		Lanche xEggBacon = new Lanche(null, "xEggBacon");
		xEggBacon.setIngredientes(ingredientes);
		xEggBacon.setPreco(ingredientes);
		lancheRepository.save(xEggBacon);
		ingredientes.removeAll(ingredientes);

		//////////////////////////////////////
		
		Cliente gustavo = new Cliente(null, "Gustavo", "123123");
		Cliente ana = new Cliente(null, "ana", "456789");

		Pedido pedidoGustavo = new Pedido(null, gustavo, xEggBacon);
		clienteRepository.save(gustavo);
		pedidoRepository.save(pedidoGustavo);

		//////////////////////////////////////

		Pedido pedidoAna = new Pedido(null, ana, xEgg);
		clienteRepository.save(ana);
		pedidoRepository.save(pedidoAna);

		//////////////////////////////////////

	}

}
