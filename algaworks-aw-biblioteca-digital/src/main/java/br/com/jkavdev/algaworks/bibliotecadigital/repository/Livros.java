package br.com.jkavdev.algaworks.bibliotecadigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.algaworks.bibliotecadigital.model.Livro;

public interface Livros extends JpaRepository<Livro, Long>{

}
