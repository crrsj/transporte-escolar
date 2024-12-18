package br.com.escolar.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.escolar.DTO.EnderecoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_endereco")
@Data
@NoArgsConstructor
public class Endereco {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String complemento;
	@ManyToOne
	@JoinColumn(name = "idAluno")
	@JsonIgnore
	private Aluno aluno;
	
	  
		public Endereco(EnderecoDTO enderecoDTO) {
			this.id = enderecoDTO.id();
			this.rua = enderecoDTO.rua();
			this.numero = enderecoDTO.numero();
			this.bairro = enderecoDTO.bairro();
			this.cidade = enderecoDTO.cidade();
			this.uf = enderecoDTO.uf();
			this.complemento = enderecoDTO.complemento();
			this.aluno = enderecoDTO.aluno();
		}


		public void atualizar(EnderecoDTO enderecoDTO) {
			if(enderecoDTO.rua() != null) {
				this.rua = enderecoDTO.rua();
			}
			if(enderecoDTO.numero() != null) {
				this.numero = enderecoDTO.numero();
			}
			
			if(enderecoDTO.bairro() != null) {
				this.bairro = enderecoDTO.bairro();
			}
			if(enderecoDTO.cidade() != null) {
				this.cidade = enderecoDTO.cidade();
			}
			
			if(enderecoDTO.uf() != null) {
				this.uf = enderecoDTO.uf();
			}
			
			if(enderecoDTO.complemento() != null) {
				this.complemento = enderecoDTO.complemento();
			}
			


		}
}
