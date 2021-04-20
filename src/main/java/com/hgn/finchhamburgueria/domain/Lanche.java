package com.hgn.finchhamburgueria.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Lanche {

	private Long id;
	private String nome;
	private Double preco;
	
	@ManyToOne
	private Pedido pedido;

	private List<Ingrediente> ingredientes = new ArrayList<>();

	public Lanche() {
	}

	public Lanche(Long id, String nome, Double preco, Pedido pedido) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

}
