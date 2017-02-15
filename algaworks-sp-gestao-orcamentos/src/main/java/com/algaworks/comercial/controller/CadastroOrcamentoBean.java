package com.algaworks.comercial.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.service.GestaoOrcamentos;

@Named
@ViewScoped
public class CadastroOrcamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GestaoOrcamentos gestaoOrcamentos;

	private Orcamento orcamento = new Orcamento();

	public void salvar() {
		gestaoOrcamentos.salvar(orcamento);
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

}