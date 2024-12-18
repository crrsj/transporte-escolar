package br.com.escolar.DTO;

import java.util.List;

import br.com.escolar.modelo.Aluno;
import br.com.escolar.modelo.Pagamento;
import br.com.escolar.modelo.Responsavel;
import jakarta.validation.constraints.NotBlank;

public record ResponsavelDTO(
		@NotBlank(message = "não pode estar em branco")
		String nome,
		@NotBlank(message = "não pode estar em branco")
		String cpf,
		@NotBlank(message = "não pode estar em branco")
		String telefone,
		@NotBlank(message = "não pode estar em branco")
		String email,
		List<Aluno> aluno,
		List<Pagamento> pagamento) {

	public ResponsavelDTO(Responsavel cadastro) {
		this(
				
				cadastro.getNome(),
				cadastro.getCpf(),
				cadastro.getTelefone(),
				cadastro.getEmail(),
				cadastro.getAluno(),
		        cadastro.getPagamento());
	}

}
