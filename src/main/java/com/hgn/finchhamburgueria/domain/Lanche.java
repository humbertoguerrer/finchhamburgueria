package com.hgn.finchhamburgueria.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Lanche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double preco;

	@OneToOne
	private Pedido pedido;

	@ManyToMany
	@JoinTable(name = "lanche_ingredientes", joinColumns = @JoinColumn(name = "lanche_id"), inverseJoinColumns = @JoinColumn(name = "ingredienet_id"))
	private List<Ingrediente> ingredientes = new ArrayList<>();

	public Lanche() {
	}

	public Lanche(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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

	public void setPreco(List<Ingrediente> ingredientes) {
		Double soma = 0.0;
		for (Ingrediente ingrediente : ingredientes) {
			soma += ingrediente.getPreco();
		}
		this.preco = soma;
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
