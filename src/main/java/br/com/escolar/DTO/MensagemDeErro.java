package br.com.escolar.DTO;

import org.springframework.http.HttpStatus;

public record MensagemDeErro(
		
		HttpStatus status, 
		String mensagem) {

}
