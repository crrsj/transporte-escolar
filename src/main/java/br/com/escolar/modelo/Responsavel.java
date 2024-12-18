package br.com.escolar.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.escolar.DTO.AtualizarResponsavelDTO;
import br.com.escolar.DTO.ResponsavelDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_responsavel")
@Data
@NoArgsConstructor
public class Responsavel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nome;
	@Column(unique = true)
	private String cpf;
	private String telefone;
	private String email;	
	@OneToMany(mappedBy = "responsavel",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<Aluno>aluno;
	@OneToMany(mappedBy = "responsavel",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<Pagamento>pagamento;
	
	public Responsavel(ResponsavelDTO responsavelDTO) {
		
		
		this.nome = responsavelDTO.nome();
		this.cpf = responsavelDTO.cpf();
		this.telefone = responsavelDTO.telefone();
		this.email = responsavelDTO.email();
		this.aluno = responsavelDTO.aluno();
		this.pagamento = responsavelDTO.pagamento();
		
	}

	public Responsavel(AtualizarResponsavelDTO atualizar) {
    	this.id = atualizar.id();		
		this.nome = atualizar.nome();
		this.telefone = atualizar.telefone();
		this.email = atualizar.email();
	}

	public void atualizandoObjeto(AtualizarResponsavelDTO atualizar) {
		if(atualizar.nome() != null) {
			this.nome = atualizar.nome();
		}
		if(atualizar.telefone() != null) {
			this.telefone = atualizar.telefone();
		}
		
		if(atualizar.email() != null) {
			this.email = atualizar.email();
		}
		
	}

}
