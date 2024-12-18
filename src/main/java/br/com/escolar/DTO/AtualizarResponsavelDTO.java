package br.com.escolar.DTO;

import br.com.escolar.modelo.Responsavel;



public record AtualizarResponsavelDTO(
		
		Long id,
		
		String nome,
		
		String telefone,		
		
		String email) {
		

	public AtualizarResponsavelDTO(Responsavel atualize) {
		this(
				atualize.getId(),
				atualize.getNome(),
				atualize.getTelefone(),
				atualize.getEmail());
	}

	

}
