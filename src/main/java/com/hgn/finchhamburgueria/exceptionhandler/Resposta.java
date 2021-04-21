package com.hgn.finchhamburgueria.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Resposta {

	private Integer status;
	private LocalDateTime dataHora;
	private String mensagem;

	private List<CampoInvalido> camposInvalidos;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<CampoInvalido> getCampoInvalido() {
		return camposInvalidos;
	}

	public void setCampoInvalido(List<CampoInvalido> campoInvalido) {
		this.camposInvalidos = campoInvalido;
	}

}
