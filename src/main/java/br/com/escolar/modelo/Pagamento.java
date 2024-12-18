package br.com.escolar.modelo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.escolar.DTO.PagamentoDTO;
import br.com.escolar.enums.Mes;
import br.com.escolar.enums.StatusPagamento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_pagamento")
@Data
@NoArgsConstructor
public class Pagamento {
    
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer ano;
	@Enumerated(EnumType.STRING)
	private Mes mes;
	private Integer diaPagamento;	
	private BigDecimal mensalidade;
	@Enumerated(EnumType.STRING)	
	private StatusPagamento status;
	@ManyToOne
	@JoinColumn(name = "idResponsavel")
	@JsonIgnore
	private Responsavel responsavel;
	
	public Pagamento(PagamentoDTO pagamentoDTO) {
		this.id  =pagamentoDTO.id();
		this.ano = pagamentoDTO.ano();
		this.mes = pagamentoDTO.mes();
		this.diaPagamento = pagamentoDTO.diaPagamento();
		this.mensalidade = pagamentoDTO.mensalidade();
		this.status = pagamentoDTO.status();
		this.responsavel = pagamentoDTO.responsavel();
	}

	public void atualizar(PagamentoDTO pagamentoDTO) {
		if(pagamentoDTO.ano() != null) {
			this.ano = pagamentoDTO.ano();
		}
		
		if(pagamentoDTO.mes() != null) {
			this.mes = pagamentoDTO.mes();
		}
		
		if(pagamentoDTO.diaPagamento() != null) {
			this.diaPagamento = pagamentoDTO.diaPagamento();
		}
		
		if(pagamentoDTO.mensalidade() != null) {
			this.mensalidade  =pagamentoDTO.mensalidade();
		}
		
		if(pagamentoDTO.status() != null) {
			this.status = pagamentoDTO.status();
		}
		
	}
}
