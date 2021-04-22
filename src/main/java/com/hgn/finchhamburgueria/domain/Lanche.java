package com.hgn.finchhamburgueria.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Lanche implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;
  private Double preco;

  @ManyToOne
  @JoinTable(
          name = "pedido_lanches",
          joinColumns = {@JoinColumn(name = "lanche_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "pedido_id", referencedColumnName = "id")})
  private Pedido pedido;

  @ManyToMany
  @JoinTable(
      name = "lanche_ingredientes",
      joinColumns = {@JoinColumn(name = "lanche_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "ingrediente_id", referencedColumnName = "id")})
  private List<Ingrediente> ingredientes = new ArrayList<>();

  public Lanche() {}

  public Lanche(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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
