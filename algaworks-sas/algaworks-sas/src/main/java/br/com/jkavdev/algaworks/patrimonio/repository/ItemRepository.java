package br.com.jkavdev.algaworks.patrimonio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.algaworks.patrimonio.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
