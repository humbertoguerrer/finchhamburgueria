package com.hgn.finchhamburgueria.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PedidoLancheCardapioDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer clienteId;
  private List<Integer> lanchesId = new ArrayList<>();

  public PedidoLancheCardapioDTO() {}

  public Integer getClienteId() {
    return clienteId;
  }

  public void setClienteId(Integer clienteId) {
    this.clienteId = clienteId;
  }

  public List<Integer> getLanchesId() {
    return lanchesId;
  }

  public void setLanchesId(List<Integer> lanchesId) {
    this.lanchesId = lanchesId;
  }
}
