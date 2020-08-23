package br.com.jkavdev.algaworks.osworks.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jkavdev.algaworks.osworks.api.domain.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
