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

import br.com.escolar.DTO.AlunoDTO;
import br.com.escolar.DTO.AtualizarAlunoDTO;
import br.com.escolar.DTO.BuscarAlunosDTO;
import br.com.escolar.servico.AlunoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/aluno")
@RequiredArgsConstructor
public class AlunoControle {
	
	private final AlunoServico alunoServico;
	
	
	@PostMapping("{responsavelId}")
	@Operation(summary = "Endpoint responsável por cadastrar alunos.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<AlunoDTO>cadastrarAluno(@RequestBody @Valid AlunoDTO alunoDTO,@PathVariable("responsavelId")
	    Long responsavelId){
		var cadastrarAluno = alunoServico.cadastrarAluno(alunoDTO, responsavelId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
				buildAndExpand(cadastrarAluno.getId()).toUri();
		return ResponseEntity.created(uri).body(new AlunoDTO(cadastrarAluno));
	}
	
	
	@GetMapping
	@Operation(summary = "Endpoint responsável pela busca de todos os alunos.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<BuscarAlunosDTO>>buscarAlunos(){
		var buscar = alunoServico.buscarAlunos();
		return ResponseEntity.ok().body(buscar);
	}

	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável pela busca de alunos pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<BuscarAlunosDTO> buscarAlunoId(@PathVariable Long id) {
		var busca = alunoServico.buscarPorId(id);
		return ResponseEntity.ok().body(new BuscarAlunosDTO(busca));
	}
	
	
	@PutMapping
	@Operation(summary = "Endpoint responsável pela atualuzação do aluno.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<AtualizarAlunoDTO>atualizarAluno(@RequestBody @Valid AtualizarAlunoDTO atualizarAlunoDTO){
		var atualizar = alunoServico.atualizarAluno(atualizarAlunoDTO);
		return ResponseEntity.ok().body(new AtualizarAlunoDTO(atualizar));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Endpoint responsável por deletar alunos.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirAlunos(@PathVariable Long id){
		alunoServico.excluirAluno(id);
		return ResponseEntity.noContent().build();
	}
}
