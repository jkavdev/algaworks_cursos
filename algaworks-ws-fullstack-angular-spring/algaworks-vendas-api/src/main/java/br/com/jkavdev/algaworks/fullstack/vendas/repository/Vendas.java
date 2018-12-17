package br.com.jkavdev.algaworks.fullstack.vendas.repository;

import br.com.jkavdev.algaworks.fullstack.vendas.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Vendas extends JpaRepository<Venda, Long> {
}
