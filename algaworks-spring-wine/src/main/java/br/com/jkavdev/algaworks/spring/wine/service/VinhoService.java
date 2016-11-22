package br.com.jkavdev.algaworks.spring.wine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jkavdev.algaworks.spring.wine.model.Vinho;
import br.com.jkavdev.algaworks.spring.wine.repository.Vinhos;

@Service
public class VinhoService {

	@Autowired
	private Vinhos vinhos;

	public void salvar(Vinho vinho) {
		this.vinhos.save(vinho);
	}
	
	public void adicionarFoto(Long codigo, String nome){
		Vinho vinho = vinhos.findOne(codigo);
		vinho.setFoto(nome);
		vinhos.save(vinho);
	}

}
