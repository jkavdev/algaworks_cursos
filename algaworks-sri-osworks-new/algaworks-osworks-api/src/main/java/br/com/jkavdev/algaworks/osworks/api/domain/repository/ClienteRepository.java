package br.com.jkavdev.algaworks.osworks.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jkavdev.algaworks.osworks.api.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("SELECT COUNT(o) FROM OrdemServico o JOIN o.cliente c WHERE c.id = ?1")
	Long countOrdensServicoPorCliente(Long clienteId);

	Cliente findByEmail(String email);

}
