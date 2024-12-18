package br.com.escolar.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escolar.modelo.Aluno;

public interface AlunoRepositorio extends JpaRepository<Aluno, Long>{

}
