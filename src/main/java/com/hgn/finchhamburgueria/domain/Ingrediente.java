package com.hgn.finchhamburgueria.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class Ingrediente implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;
  private Double preco;

  @ManyToMany()
  @JoinTable(
      name = "lanche_ingredientes",
      joinColumns = {@JoinColumn(name = "ingrediente_id")},
      inverseJoinColumns = {@JoinColumn(name = "lanche_id")})
  private List<Lanche> lanche;

  public Ingrediente() {}

  public Ingrediente(Integer id, String nome, Double preco) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
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

  public void setPreco(Double preco) {
    this.preco = preco;
  }

}
