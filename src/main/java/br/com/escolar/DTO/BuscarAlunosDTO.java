package br.com.escolar.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.escolar.enums.AnoLetivo;
import br.com.escolar.enums.Turno;
import br.com.escolar.modelo.Aluno;
import br.com.escolar.modelo.Endereco;
import br.com.escolar.modelo.Responsavel;

public record BuscarAlunosDTO(
		
		Long id,
		String nome,
		LocalDate dataNasc,		
		AnoLetivo anoLetivo,
		String turma,
		Turno turno,
		LocalTime horaEntrada,
		LocalTime horaSaida,
		Responsavel responsavel,	
	    List<Endereco> endereco)    {
	
	public BuscarAlunosDTO(Aluno aluno) {
		this(
				aluno.getId(),
				aluno.getNome(),
				aluno.getDataNasc(),
				aluno.getAnoLetivo(),
				aluno.getTurma(),
				aluno.getTurno(),
				aluno.getHoraEntrada(),
				aluno.getHoraSaida(),
				aluno.getResponsavel(),
				aluno.getEndereco());
	}

}
