package br.com.escolar.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.escolar.DTO.EnderecoDTO;
import br.com.escolar.modelo.Endereco;
import br.com.escolar.repositorio.AlunoRepositorio;
import br.com.escolar.repositorio.EnderecoRepositorio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnderecoServico {
	
	
	private final EnderecoRepositorio enderecoRepositorio;
	private final AlunoRepositorio alunoRepositorio;
	
	public Endereco cadastrarEndereco(EnderecoDTO enderecoDTO,Long alunoId) {
		var cadastrar = new Endereco(enderecoDTO);
		var aluno = alunoRepositorio.findById(alunoId).get();
		cadastrar.setAluno(aluno);
		return enderecoRepositorio.save(cadastrar);
		
	}
	
	@Transactional
	public Endereco atualizarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
		var atualize = enderecoRepositorio.getReferenceById(enderecoDTO.id());
		atualize.atualizar(enderecoDTO);
		return atualize;
	}

	public void excluirEndereco(Long id) {
		enderecoRepositorio.deleteById(id);
	}
	
	public List<EnderecoDTO>buscarEnderecos(){
		var busca = enderecoRepositorio.findAll().stream().map(EnderecoDTO::new).toList();
		return busca;
	}
	
	public Endereco buscarId(Long id) {
		Optional<Endereco>busca = enderecoRepositorio.findById(id);
		return busca.get();
	}
}
