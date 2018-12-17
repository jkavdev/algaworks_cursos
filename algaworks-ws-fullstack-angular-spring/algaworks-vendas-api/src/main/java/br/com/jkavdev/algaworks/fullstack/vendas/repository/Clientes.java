package br.com.jkavdev.algaworks.fullstack.vendas.repository;

import br.com.jkavdev.algaworks.fullstack.vendas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Clientes extends JpaRepository<Cliente, Long> {
}
