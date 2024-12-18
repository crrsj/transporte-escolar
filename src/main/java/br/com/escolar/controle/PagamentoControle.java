package br.com.escolar.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.escolar.DTO.PagamentoDTO;
import br.com.escolar.servico.PagamentoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/pagamento")
@RequiredArgsConstructor
public class PagamentoControle {
	
	private final PagamentoServico pagamentoServico;
	
	@PostMapping("{responsavelId}")
	@Operation(summary = "Endpoint responsável por cadastrar pagamentos.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<PagamentoDTO>criarPagamento(@RequestBody @Valid PagamentoDTO pagamentoDTO,
			@PathVariable("responsavelId") Long responsavelId){
		var cadastro = pagamentoServico.criarPagamento(pagamentoDTO, responsavelId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
		buildAndExpand(cadastro.getId()).toUri();
		return ResponseEntity.created(uri).body(new PagamentoDTO(cadastro));
	}
	
	@GetMapping
	@Operation(summary = "Endpoint responsável pela busca de todos os pagamentos.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<PagamentoDTO>>listarPagamentos(){
		var listar = pagamentoServico.buscarPagamentos();
		return ResponseEntity.ok().body(listar);
	}

	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável pela busca de pagamento pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<PagamentoDTO>buscarId(@PathVariable Long id){
		var buscar = pagamentoServico.buscarId(id);
		return ResponseEntity.ok().body(new PagamentoDTO(buscar));
		
	}
	
	@PutMapping
	@Operation(summary = "Endpoint responsável pela atualização de pagamentos.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<PagamentoDTO>atualizarPagamento(@RequestBody @Valid PagamentoDTO pagamentoDTO){
		var atualize = pagamentoServico.atualizarPagamento(pagamentoDTO);
		return ResponseEntity.ok().body(new PagamentoDTO(atualize));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Endpoint responsável por excluir pagamentos.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirPagamento(@PathVariable Long id){
		pagamentoServico.excluirPagamento(id);
		return ResponseEntity.noContent().build();
	}
}
