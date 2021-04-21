package com.hgn.finchhamburgueria.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<CampoInvalido> camposInvalidos = new ArrayList<>();

		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nomeErro = ((FieldError) error).getField();
			String mensagem = error.getDefaultMessage();
			camposInvalidos.add(new CampoInvalido(nomeErro, mensagem));
		}

		Resposta resposta = new Resposta();
		resposta.setStatus(status.value());
		resposta.setMensagem("Preencha corretamente.");
		resposta.setDataHora(LocalDateTime.now());
		resposta.setCampoInvalido(camposInvalidos);
		return super.handleExceptionInternal(ex, resposta, headers, status, request);
	}

}
