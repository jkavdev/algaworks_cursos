package br.com.jkavdev.algaworks.osworks.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.algaworks.osworks.api.domain.model.OrdemServico;

public interface OrdemServiceRepository extends JpaRepository<OrdemServico, Long> {

}
