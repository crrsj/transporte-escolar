package br.com.escolar.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.escolar.DTO.AlunoDTO;
import br.com.escolar.DTO.AtualizarAlunoDTO;
import br.com.escolar.DTO.BuscarAlunosDTO;
import br.com.escolar.modelo.Aluno;
import br.com.escolar.repositorio.AlunoRepositorio;
import br.com.escolar.repositorio.ResponsavelRepositorio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoServico {
	
	private final AlunoRepositorio alunoRepositorio;
	private final ResponsavelRepositorio responsavelRepositorio;
	
	public Aluno cadastrarAluno(AlunoDTO alunoDTO,Long responsavelId) {
		var cadastrarAluno = new Aluno(alunoDTO);
		var responsavel = responsavelRepositorio.findById(responsavelId).get();
		cadastrarAluno.setResponsavel(responsavel);
		return alunoRepositorio.save(cadastrarAluno);
		
	}

	public List<BuscarAlunosDTO> buscarAlunos() {
		var buscar = alunoRepositorio.findAll().stream().map(BuscarAlunosDTO::new).toList();
		return buscar;
	}
	
	public Aluno buscarPorId(Long id) {
		Optional<Aluno>busca = alunoRepositorio.findById(id);
		return busca.get();
	}
	
	@Transactional
	public Aluno atualizarAluno(AtualizarAlunoDTO atualizarAlunoDTO){
		var atualizar = alunoRepositorio.getReferenceById(atualizarAlunoDTO.id());
		atualizar.atualizando(atualizarAlunoDTO);
		return atualizar;
	}
	
	public void excluirAluno(Long id) {
		alunoRepositorio.deleteById(id);
	}
}
