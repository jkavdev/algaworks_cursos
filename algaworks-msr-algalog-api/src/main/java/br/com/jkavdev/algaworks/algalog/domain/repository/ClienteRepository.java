package br.com.jkavdev.algaworks.algalog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.algaworks.algalog.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
