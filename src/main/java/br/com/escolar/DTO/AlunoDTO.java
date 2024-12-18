package br.com.escolar.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.escolar.enums.AnoLetivo;
import br.com.escolar.enums.Turno;
import br.com.escolar.modelo.Aluno;
import br.com.escolar.modelo.Endereco;
import br.com.escolar.modelo.Responsavel;
import jakarta.validation.constraints.NotBlank;

public record AlunoDTO(
		@NotBlank(message = "não pode estar em branco")
		String nome,
		@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
		LocalDate dataNasc,
		@NotBlank(message = "não pode estar em branco")
		String cpf,
		AnoLetivo anoLetivo,
		@NotBlank(message = "não pode estar em branco")
		String turma,
		Turno turno,		
		LocalTime horaEntrada,
		LocalTime horaSaida,
		Responsavel responsavel,
		List<Endereco>endereco) {

	public AlunoDTO(Aluno cadastrarAluno) {
		this(
				cadastrarAluno.getNome(),
				cadastrarAluno.getDataNasc(),
				cadastrarAluno.getCpf(),
				cadastrarAluno.getAnoLetivo(),
				cadastrarAluno.getTurma(),
				cadastrarAluno.getTurno(),
				cadastrarAluno.getHoraEntrada(),
				cadastrarAluno.getHoraSaida(),
				cadastrarAluno.getResponsavel(),
				cadastrarAluno.getEndereco());
	}

	
}
