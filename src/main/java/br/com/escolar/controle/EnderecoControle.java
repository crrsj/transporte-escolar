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

import br.com.escolar.DTO.EnderecoDTO;
import br.com.escolar.servico.EnderecoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/endereco")
@RequiredArgsConstructor
public class EnderecoControle {
	
	private final EnderecoServico enderecoServico;
	
	
	@PostMapping("{alunoId}")
	@Operation(summary = "Endpoint responsável por cadastrar endereço.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<EnderecoDTO>cadastrarEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO,
			@PathVariable("alunoId")Long alunoId){
		var cadastrar = enderecoServico.cadastrarEndereco(enderecoDTO, alunoId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
			buildAndExpand(cadastrar.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDTO(cadastrar));
		
		
	}
	
	@PutMapping
	@Operation(summary = "Endpoint responsável pela atualização do endereço.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<EnderecoDTO>atualizarEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO){
		var atualizar = enderecoServico.atualizarEndereco(enderecoDTO);
		return ResponseEntity.ok().body(new EnderecoDTO(atualizar));
	}
	
	
	@DeleteMapping("{id}")
	@Operation(summary = "Endpoint responsável por deletar endereço pelo id.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirEndereco(@PathVariable Long id){
		enderecoServico.excluirEndereco(id);
		return ResponseEntity.noContent().build();
	}

	
	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável pela busca de endereço pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<EnderecoDTO>buscaId(@PathVariable Long id){
		var busca = enderecoServico.buscarId(id);
		return ResponseEntity.ok().body(new EnderecoDTO(busca));
	}
	
	
	@GetMapping
	@Operation(summary = "Endpoint responsável pela busca de todos os endereços.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<EnderecoDTO>>buscarTodos(){
		var buscando = enderecoServico.buscarEnderecos();
		return ResponseEntity.ok().body(buscando);
	}
}
