package com.hgn.finchhamburgueria.DTO;

import java.io.Serializable;

public class NovoLancheDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private Double preco;

	private Integer pedidoId;

	private Integer ingrediente1id;
	private Integer ingrediente2id;
	private Integer ingrediente3id;
	private Integer ingrediente4id;
	private Integer ingrediente5id;

	public NovoLancheDTO() {
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

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Integer getIngrediente1id() {
		return ingrediente1id;
	}

	public void setIngrediente1id(Integer ingrediente1id) {
		this.ingrediente1id = ingrediente1id;
	}

	public Integer getIngrediente2id() {
		return ingrediente2id;
	}

	public void setIngrediente2id(Integer ingrediente2id) {
		this.ingrediente2id = ingrediente2id;
	}

	public Integer getIngrediente3id() {
		return ingrediente3id;
	}

	public void setIngrediente3id(Integer ingrediente3id) {
		this.ingrediente3id = ingrediente3id;
	}

	public Integer getIngrediente4id() {
		return ingrediente4id;
	}

	public void setIngrediente4id(Integer ingrediente4id) {
		this.ingrediente4id = ingrediente4id;
	}

	public Integer getIngrediente5id() {
		return ingrediente5id;
	}

	public void setIngrediente5id(Integer ingrediente5id) {
		this.ingrediente5id = ingrediente5id;
	}

}
