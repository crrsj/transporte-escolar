package br.com.escolar.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.escolar.DTO.PagamentoDTO;
import br.com.escolar.modelo.Pagamento;
import br.com.escolar.repositorio.PagamentoRepositorio;
import br.com.escolar.repositorio.ResponsavelRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagamentoServico {
	
	private final PagamentoRepositorio pagamentoRepositorio; 
	private final ResponsavelRepositorio responsavelRepositorio;
	
	
	public Pagamento criarPagamento(PagamentoDTO pagamentoDTO,Long responsavelId) {
		var pagamento = new Pagamento(pagamentoDTO);
		var responsavel = responsavelRepositorio.findById(responsavelId).get();
		pagamento.setResponsavel(responsavel);
		return pagamentoRepositorio.save(pagamento);
	}
	
	public Pagamento buscarId(Long id) {
		Optional<Pagamento>busca = pagamentoRepositorio.findById(id);
		return busca.get();
	}
	
	
	public List<PagamentoDTO>buscarPagamentos(){
		var buscar = pagamentoRepositorio.findAll().stream().map(PagamentoDTO::new).toList();
		return buscar;
	}
	

	public Pagamento atualizarPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
		var atualize = pagamentoRepositorio.getReferenceById(pagamentoDTO.id());
		atualize.atualizar(pagamentoDTO);
		return atualize;
	}
	
	public void excluirPagamento(Long id) {
		pagamentoRepositorio.deleteById(id);
	}
}
