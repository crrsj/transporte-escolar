package br.com.escolar.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escolar.modelo.Pagamento;

public interface PagamentoRepositorio extends JpaRepository<Pagamento, Long>{

}
