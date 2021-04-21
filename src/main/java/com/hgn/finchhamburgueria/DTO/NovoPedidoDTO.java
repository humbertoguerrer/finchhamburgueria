package com.hgn.finchhamburgueria.DTO;

import java.io.Serializable;

public class NovoPedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer clienteId;

	private Double precoPedido;

	private Integer lancheId;

	public NovoPedidoDTO() {
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Double getPrecoPedido() {
		return precoPedido;
	}

	public void setPrecoPedido(Double precoPedido) {
		this.precoPedido = precoPedido;
	}

	public Integer getLancheId() {
		return lancheId;
	}

	public void setLancheId(Integer lancheId) {
		this.lancheId = lancheId;
	}

}
