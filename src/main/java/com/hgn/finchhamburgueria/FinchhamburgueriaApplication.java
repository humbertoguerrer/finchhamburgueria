package com.hgn.finchhamburgueria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinchhamburgueriaApplication {

//	@Autowired
//	private ClienteRepository clienteRepository;
//
//	@Autowired
//	private PedidoRepository pedidoRepository;
//
//	@Autowired
//	private LancheRepository lancheRepository;
//
//	@Autowired
//	private IngredienteRepository ingredienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinchhamburgueriaApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		Ingrediente alface = new Ingrediente(null, "alface", 0.40);
//		Ingrediente bacon = new Ingrediente(null, "bacon", 2.00);
//		Ingrediente carne = new Ingrediente(null, "carne", 0.80);
//		Ingrediente ovo = new Ingrediente(null, "ovo", 0.40);
//		Ingrediente queijo = new Ingrediente(null, "queijo", 1.50);
//
//		ingredienteRepository.save(alface);
//		ingredienteRepository.save(bacon);
//		ingredienteRepository.save(carne);
//		ingredienteRepository.save(ovo);
//		ingredienteRepository.save(queijo);
//
//		//////////////////////////////////////
//
//		List<Ingrediente> ingredientes = new ArrayList<>();
//		ingredientes.add(bacon);
//		ingredientes.add(carne);
//		ingredientes.add(queijo);
//
//		Lanche xBacon = new Lanche(null, "xBacon");
//		xBacon.setIngredientes(ingredientes);
//		xBacon.setPreco(4.3);
//		lancheRepository.save(xBacon);
//		ingredientes.removeAll(ingredientes);
//
//		//////////////////////////////////////
//
//		ingredientes.add(carne);
//		ingredientes.add(queijo);
//
//		Lanche xBurguer = new Lanche(null, "xBurguer");
//		xBacon.setIngredientes(ingredientes);
//		xBurguer.setPreco(2.3);
//		lancheRepository.save(xBurguer);
//		ingredientes.removeAll(ingredientes);
//
//		//////////////////////////////////////
//
//		ingredientes.add(ovo);
//		ingredientes.add(carne);
//		ingredientes.add(queijo);
//
//		Lanche xEgg = new Lanche(null, "xEgg");
//		xEgg.setIngredientes(ingredientes);
//		xEgg.setPreco(2.7);
//		lancheRepository.save(xEgg);
//		ingredientes.removeAll(ingredientes);
//
//		//////////////////////////////////////
//
//		ingredientes.add(ovo);
//		ingredientes.add(bacon);
//		ingredientes.add(carne);
//		ingredientes.add(queijo);
//
//		Lanche xEggBacon = new Lanche(null, "xEggBacon");
//		xEggBacon.setIngredientes(ingredientes);
//		xEggBacon.setPreco(4.7);
//		lancheRepository.save(xEggBacon);
//		ingredientes.removeAll(ingredientes);

	//////////////////////////////////////

//		Cliente gustavo = new Cliente(null, "Gustavo", "846351");
//		Cliente humberto = new Cliente(null, "Humberto", "846351");
//		Cliente ana = new Cliente(null, "Ana", "846351");
//
//		Pedido gustavoPedido = new Pedido(null, gustavo);
//		Pedido humbertoPedido = new Pedido(null, humberto);
//		Pedido anaPedido = new Pedido(null, ana);
//
//		List<Lanche> lanches = new ArrayList<>();
//
//		lanches.add(xEggBacon);
//		gustavo.setPedido(gustavoPedido);
//		gustavoPedido.setLanches(lanches);
//		clienteRepository.save(gustavo);
//		pedidoRepository.save(gustavoPedido);
//		lanches.removeAll(lanches);
//
//		lanches.add(xEgg);
//		lanches.add(xBurguer);
//		humberto.setPedido(humbertoPedido);
//		humbertoPedido.setLanches(lanches);
//		clienteRepository.save(humberto);
//		pedidoRepository.save(humbertoPedido);
//		lanches.removeAll(lanches);
//
//		lanches.add(xBurguer);
//		ana.setPedido(anaPedido);
//		anaPedido.setLanches(lanches);
//		clienteRepository.save(ana);
//		pedidoRepository.save(anaPedido);
}
