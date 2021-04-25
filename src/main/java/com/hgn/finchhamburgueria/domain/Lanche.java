package com.hgn.finchhamburgueria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lanche implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;
  private Double preco;

  @JsonIgnore
  @ManyToMany
  @JoinTable(
      name = "pedido_lanches",
      joinColumns = {@JoinColumn(name = "lanche_id")},
      inverseJoinColumns = {@JoinColumn(name = "pedido_id")})
  private List<Pedido> pedido;

  // @JsonIgnore
  @ManyToMany
  @JoinTable(
      name = "lanche_ingredientes",
      joinColumns = {@JoinColumn(name = "lanche_id")},
      inverseJoinColumns = {@JoinColumn(name = "ingrediente_id")})
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
      if (ingrediente.getId() == 1 && ingrediente.getId() != 2) {
        this.preco = soma * 0.10;
//      } else if (ingrediente.getId() == 3 || ingrediente.getId() == 5) {
//        if (ingrediente.getQtdIngrediente() >= 3 && ingrediente.getQtdIngrediente() % 3 == 0) {
//          Integer promocaoIngredientes = (ingrediente.getQtdIngrediente() / 3) * 2;
//          this.preco = preco + (promocaoIngredientes * ingrediente.getPreco());
//        }
      }
    }
  }

  public List<Pedido> getPedido() {
    return pedido;
  }

  public void setPedido(List<Pedido> pedido) {
    this.pedido = pedido;
  }

  public List<Ingrediente> getIngredientes() {
    return ingredientes;
  }

  public void setIngredientes(List<Ingrediente> ingredientes) {
    this.ingredientes = ingredientes;
  }
}
