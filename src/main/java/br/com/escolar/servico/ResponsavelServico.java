package br.com.escolar.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.escolar.DTO.AtualizarResponsavelDTO;
import br.com.escolar.DTO.BuscarResponsaveisDTO;
import br.com.escolar.DTO.ResponsavelDTO;
import br.com.escolar.modelo.Responsavel;
import br.com.escolar.repositorio.ResponsavelRepositorio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResponsavelServico {
	
	private final ResponsavelRepositorio responsavelRepositorio;
	
	public Responsavel cadastrarResponsavel(ResponsavelDTO  responsavelDTO ) {
		var cadastrar = new Responsavel(responsavelDTO);
		return responsavelRepositorio.save(cadastrar);
		
	}
	
	public List<BuscarResponsaveisDTO>buscarTodos(){
		var todos = responsavelRepositorio.findAll().stream().
				map(BuscarResponsaveisDTO::new).toList();
		return todos;
	}

	public Responsavel buscarResponsavel(Long id) {
		Optional<Responsavel>buscar = responsavelRepositorio.findById(id);
		return buscar.get();
	}
	
	 
    @Transactional
	public Responsavel atualizarResponsavel(AtualizarResponsavelDTO atualizar) {	
	    var atualize =responsavelRepositorio.getReferenceById(atualizar.id());
        atualize.atualizandoObjeto(atualizar);
		return atualize;
	}
	
	public void excluirResponsavel(Long id) {
		responsavelRepositorio.deleteById(id);
	}
}
