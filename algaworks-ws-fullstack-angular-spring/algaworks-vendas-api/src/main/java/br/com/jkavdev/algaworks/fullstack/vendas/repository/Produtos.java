package br.com.jkavdev.algaworks.fullstack.vendas.repository;

import br.com.jkavdev.algaworks.fullstack.vendas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Long> {
}
