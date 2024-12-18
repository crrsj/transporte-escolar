package br.com.escolar.DTO;

import java.math.BigDecimal;

import br.com.escolar.enums.Mes;
import br.com.escolar.enums.StatusPagamento;
import br.com.escolar.modelo.Pagamento;
import br.com.escolar.modelo.Responsavel;
import jakarta.validation.constraints.NotNull;

public record PagamentoDTO(
		Long id,
		@NotNull(message = "não pode estar em branco ou nulo")
		Integer ano,
		Mes mes,
		@NotNull(message = "não pode estar em branco ou nulo")
		Integer diaPagamento,
		@NotNull(message = "não pode estar em branco ou nulo")
		BigDecimal mensalidade,
		StatusPagamento status,
		Responsavel responsavel) {

	public PagamentoDTO(Pagamento pagamento) {
		this(
				pagamento.getId(),
				pagamento.getAno(),
				pagamento.getMes(),
				pagamento.getDiaPagamento(),
				pagamento.getMensalidade(),
				pagamento.getStatus(),
				pagamento.getResponsavel());
	}
}
