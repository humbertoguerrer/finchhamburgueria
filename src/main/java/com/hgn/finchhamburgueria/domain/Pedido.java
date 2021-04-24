package com.hgn.finchhamburgueria.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Double precoPedido;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @ManyToMany
  @JoinTable(
      name = "pedido_lanches",
      joinColumns = {@JoinColumn(name = "pedido_id")},
      inverseJoinColumns = {@JoinColumn(name = "lanche_id")})
  private List<Lanche> lanches = new ArrayList<>();

  public Pedido() {}

  public Pedido(Integer id, Cliente cliente) {
    this.id = id;
    this.cliente = cliente;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {

    this.id = id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Double getPrecoPedido() {
    return precoPedido;
  }

  public void setPrecoPedido(List<Lanche> lanches) {
    Double soma = 0.0;
    for (Lanche lanche : lanches) {
      soma += lanche.getPreco();
    }
    this.precoPedido = soma;
  }

  public List<Lanche> getLanches() {
    return lanches;
  }

  public void setLanches(List<Lanche> lanches) {
    this.lanches = lanches;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Pedido other = (Pedido) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
