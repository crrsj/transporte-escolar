package br.com.escolar.DTO;

import br.com.escolar.modelo.Aluno;
import br.com.escolar.modelo.Endereco;
import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(
		
		Long id,
		@NotBlank(message = "não pode estar em branco")
		String rua,
		@NotBlank(message = "não pode estar em branco")
		String numero,
		@NotBlank(message = "não pode estar em branco")
		String bairro,
		@NotBlank(message = "não pode estar em branco")
		String cidade,
		@NotBlank(message = "não pode estar em branco")
		String uf,
		String complemento,
		Aluno aluno ) {

	public EnderecoDTO(Endereco cadastrar) {
		this(
				cadastrar.getId(),
				cadastrar.getRua(),
				cadastrar.getNumero(),
				cadastrar.getBairro(),
				cadastrar.getCidade(),
				cadastrar.getUf(),
				cadastrar.getComplemento(),
				cadastrar.getAluno());
	}

}
