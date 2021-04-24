package com.hgn.finchhamburgueria;

import com.hgn.finchhamburgueria.domain.Cliente;
import com.hgn.finchhamburgueria.domain.Ingrediente;
import com.hgn.finchhamburgueria.domain.Lanche;
import com.hgn.finchhamburgueria.domain.Pedido;
import com.hgn.finchhamburgueria.repositories.ClienteRepository;
import com.hgn.finchhamburgueria.repositories.IngredienteRepository;
import com.hgn.finchhamburgueria.repositories.LancheRepository;
import com.hgn.finchhamburgueria.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FinchhamburgueriaApplication implements CommandLineRunner {

  @Autowired private LancheRepository lancheRepository;

  @Autowired private IngredienteRepository ingredienteRepository;

  @Autowired private ClienteRepository clienteRepository;

  @Autowired private PedidoRepository pedidoRepository;

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

    Lanche xBacon = new Lanche(null, "xBacon");
    xBacon.getIngredientes().add(bacon);
    xBacon.getIngredientes().add(carne);
    xBacon.getIngredientes().add(queijo);
    xBacon.setPreco(xBacon.getIngredientes());
    lancheRepository.save(xBacon);

    //////////////////////////////////////

    Lanche xBurguer = new Lanche(null, "xBurguer");
    xBurguer.getIngredientes().add(carne);
    xBurguer.getIngredientes().add(queijo);
    xBurguer.setPreco(xBurguer.getIngredientes());
    lancheRepository.save(xBurguer);

    //////////////////////////////////////

    Lanche xEgg = new Lanche(null, "xEgg");
    xEgg.getIngredientes().add(ovo);
    xEgg.getIngredientes().add(carne);
    xEgg.getIngredientes().add(queijo);
    xEgg.setPreco(xEgg.getIngredientes());
    lancheRepository.save(xEgg);

    //////////////////////////////////////

    Lanche xEggBacon = new Lanche(null, "xEggBacon");
    xEggBacon.getIngredientes().add(ovo);
    xEggBacon.getIngredientes().add(bacon);
    xEggBacon.getIngredientes().add(carne);
    xEggBacon.getIngredientes().add(queijo);
    xEggBacon.setPreco(xEggBacon.getIngredientes());
    lancheRepository.save(xEggBacon);

    //////////////////////////////////////

    Cliente humberto = new Cliente(null, "Humberto", "8645314");
    clienteRepository.save(humberto);
    Pedido pedido = new Pedido(null, humberto);
    pedido.getLanches().add(xEggBacon);
    pedido.getLanches().add(xEgg);
    pedidoRepository.save(pedido);
  }
}
