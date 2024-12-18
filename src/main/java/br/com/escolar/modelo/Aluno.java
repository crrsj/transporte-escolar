package br.com.escolar.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.escolar.DTO.AlunoDTO;
import br.com.escolar.DTO.AtualizarAlunoDTO;
import br.com.escolar.enums.AnoLetivo;
import br.com.escolar.enums.Turno;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_alunos")
@Data
@NoArgsConstructor
public class Aluno {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String nome;	
	private LocalDate dataNasc;
	private String cpf;
	private AnoLetivo anoLetivo;
	private String turma;
	@Enumerated(EnumType.STRING)
	private Turno turno;	
	private LocalTime horaEntrada;
	private LocalTime horaSaida;
	@ManyToOne
	@JoinColumn(name = "idResponsavel")
	@JsonIgnore
	private Responsavel responsavel;
	@OneToMany(mappedBy = "aluno",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<Endereco>endereco;
	
	public Aluno(AlunoDTO alunoDTO) {
		this.nome = alunoDTO.nome();
		this.dataNasc = alunoDTO.dataNasc();
		this.cpf = alunoDTO.cpf();
		this.anoLetivo = alunoDTO.anoLetivo();
		this.turma = alunoDTO.turma();
		this.turno = alunoDTO.turno();
		this.horaEntrada = alunoDTO.horaEntrada();
		this.horaSaida = alunoDTO.horaSaida();
		this.responsavel = alunoDTO.responsavel();
		this.endereco = alunoDTO.endereco();
	}

	public void atualizando(AtualizarAlunoDTO atualizarAlunoDTO) {
	if(atualizarAlunoDTO.nome() != null) {
		this.nome = atualizarAlunoDTO.nome();
	}
	
	if(atualizarAlunoDTO.dataNasc() != null) {
		this.dataNasc = atualizarAlunoDTO.dataNasc();
	}
	
	if(atualizarAlunoDTO.anoLetivo() != null) {
		this.anoLetivo = atualizarAlunoDTO.anoLetivo();
	}
		
    if(atualizarAlunoDTO.turma() != null) {
    	this.turma = atualizarAlunoDTO.turma();
    	
    }
    
    if(atualizarAlunoDTO.turno() != null) {
    	this.turno = atualizarAlunoDTO.turno();
    }
    
    if(atualizarAlunoDTO.horaEntrada() != null) {
    	this.horaEntrada = atualizarAlunoDTO.horaEntrada();
    }
    
    if(atualizarAlunoDTO.horaSaida() != null) {
    	this.horaSaida = atualizarAlunoDTO.horaSaida();
    }
	}

}
