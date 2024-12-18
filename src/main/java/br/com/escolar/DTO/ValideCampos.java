package br.com.escolar.DTO;

import org.springframework.validation.FieldError;

public record ValideCampos(
		String campo,
		String mensagem) {
 
	  public ValideCampos(FieldError erro) {
		 
		  this(erro.getField(),erro.getDefaultMessage());
	  }
}
