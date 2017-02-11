package br.com.jkavdev.algaworks.imobiliaria.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jkavdev.algaworks.imobiliaria.model.Imovel;

@Repository
public class Imoveis {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void guardar(Imovel imovel) {
		manager.persist(imovel);
	}

}
