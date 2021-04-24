package com.hgn.finchhamburgueria.DTO;

import com.hgn.finchhamburgueria.domain.Ingrediente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PedidoNovoLancheDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  public Integer clienteId;

  public List<Integer> ingredientesId = new ArrayList<>();

  public PedidoNovoLancheDTO() {}

  public Integer getClienteId() {
    return clienteId;
  }

  public void setClienteId(Integer clienteId) {
    this.clienteId = clienteId;
  }

  public List<Integer> getIngredientesId() {
    return ingredientesId;
  }

  public void setIngredientesId(List<Integer> ingredientes) {
    this.ingredientesId = ingredientes;
  }
}
