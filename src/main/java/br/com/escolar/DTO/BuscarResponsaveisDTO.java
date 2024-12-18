package br.com.escolar.DTO;

import java.util.List;

import br.com.escolar.modelo.Aluno;
import br.com.escolar.modelo.Pagamento;
import br.com.escolar.modelo.Responsavel;

public record BuscarResponsaveisDTO(
		
		Long id,		
		String nome,
		String telefone,
		String email,
		List<Aluno> aluno,
		List<Pagamento>pagamento) {
	
	public BuscarResponsaveisDTO(Responsavel buscar) {
		this(
				buscar.getId(),				
				buscar.getNome(),
				buscar.getTelefone(),
				buscar.getEmail(),
				buscar.getAluno(),
				buscar.getPagamento());
	}

}
