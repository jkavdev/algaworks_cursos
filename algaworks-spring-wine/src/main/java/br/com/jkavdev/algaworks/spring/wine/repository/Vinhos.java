package br.com.jkavdev.algaworks.spring.wine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.algaworks.spring.wine.model.Vinho;

public interface Vinhos extends JpaRepository<Vinho, Long> {

}
