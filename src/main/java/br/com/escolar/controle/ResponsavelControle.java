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

import br.com.escolar.DTO.AtualizarResponsavelDTO;
import br.com.escolar.DTO.BuscarResponsaveisDTO;
import br.com.escolar.DTO.ResponsavelDTO;
import br.com.escolar.servico.ResponsavelServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/responsavel")
@RequiredArgsConstructor
public class ResponsavelControle {

	
	private final ResponsavelServico responsavelServico;
	
	
	@PostMapping
	@Operation(summary = "Endpoint responsável por cadastrar responsáveis pelos alunos.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ResponsavelDTO>cadastrarResponsavel(@RequestBody @Valid ResponsavelDTO responsavelDTO){
		var cadastro = responsavelServico.cadastrarResponsavel(responsavelDTO);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
		buildAndExpand(cadastro.getId()).toUri();
		return ResponseEntity.created(uri).body(new ResponsavelDTO(cadastro));
	}
	
	@GetMapping
    @Operation(summary = "Endpoint responsável pela busca de todos os responsáveis.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<BuscarResponsaveisDTO>>buscarResponsaveis(){
		var buscar = responsavelServico.buscarTodos();
		return ResponseEntity.ok().body(buscar);
	}
	
	@PutMapping
    @Operation(summary = "Endpoint responsável pela atualização dos responsáveis.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<AtualizarResponsavelDTO>atualizarResponsavel(@RequestBody @Valid AtualizarResponsavelDTO atualizar){
		var atualize = responsavelServico.atualizarResponsavel(atualizar);
		return ResponseEntity.ok().body(new AtualizarResponsavelDTO(atualize));
	}
	
	
	@DeleteMapping("{id}")
	@Operation(summary = "Endpoint responsável por excluir responsável.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirResponsavel(@PathVariable Long id){
		responsavelServico.excluirResponsavel(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável pela busca do responsável pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<BuscarResponsaveisDTO>buscarPorId(@PathVariable Long id){
		var busca = responsavelServico.buscarResponsavel(id);
		return ResponseEntity.ok().body(new BuscarResponsaveisDTO(busca));
	}
}
