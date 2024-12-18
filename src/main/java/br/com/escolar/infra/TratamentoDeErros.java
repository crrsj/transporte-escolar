package br.com.escolar.infra;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.escolar.DTO.MensagemDeErro;
import br.com.escolar.DTO.ValideCampos;

@ControllerAdvice
public class TratamentoDeErros {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>validandoCampos(MethodArgumentNotValidException ex){
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(ValideCampos::new).toList());
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MensagemDeErro>objetoNaoEncontrado(){
		var buscarObjeto = new MensagemDeErro(HttpStatus.NOT_FOUND, "Objetonão encontrado !");
		return new ResponseEntity<>(buscarObjeto,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<MensagemDeErro>camposUnicos(){
		var unicos = new MensagemDeErro(HttpStatus.BAD_REQUEST, "campos,cpf,email ou telefone já cadastrados");
		return new ResponseEntity<>(unicos,HttpStatus.BAD_REQUEST);
	}
}
