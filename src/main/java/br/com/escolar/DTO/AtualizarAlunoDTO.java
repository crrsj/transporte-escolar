package br.com.escolar.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.escolar.enums.AnoLetivo;
import br.com.escolar.enums.Turno;
import br.com.escolar.modelo.Aluno;


public record AtualizarAlunoDTO(
		
		Long id,
		String nome,
		LocalDate dataNasc,		
		AnoLetivo anoLetivo,
		String turma,
		Turno turno,
		LocalTime horaEntrada,
		LocalTime horaSaida	
		
		                   ) {

	public AtualizarAlunoDTO(Aluno atualizar) {
		this(
				atualizar.getId(),
				atualizar.getNome(),
				atualizar.getDataNasc(),
				atualizar.getAnoLetivo(),
				atualizar.getTurma(),
				atualizar.getTurno(),
				atualizar.getHoraEntrada(),
				atualizar.getHoraSaida());
	}

}
