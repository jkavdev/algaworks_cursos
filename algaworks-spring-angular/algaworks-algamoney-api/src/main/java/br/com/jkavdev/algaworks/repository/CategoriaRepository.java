package br.com.jkavdev.algaworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.algaworks.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
