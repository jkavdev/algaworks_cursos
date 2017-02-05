package br.com.jkavdev.algaworks.compras.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.compras.model.Cidade;
import br.com.jkavdev.algaworks.compras.model.Estado;
import br.com.jkavdev.algaworks.compras.model.Fornecedor;
import br.com.jkavdev.algaworks.compras.repository.Cidades;
import br.com.jkavdev.algaworks.compras.repository.Estados;
import br.com.jkavdev.algaworks.compras.repository.Fornecedores;

@Named
@ViewScoped
public class CadastroFornecedoresBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Fornecedores fornecedores;
	@Inject
	private Estados estados;
	@Inject
	private Cidades cidades;

	private Fornecedor fornecedor;
	private Estado estado;

	private List<Estado> todosEstados;
	private List<Cidade> cidadesPorEstado;
	private List<Fornecedor> todosFornecedores;

	public void inicializar() {
		this.fornecedor = new Fornecedor();
		this.estado = null;
		this.todosFornecedores = this.fornecedores.todos();

		if (!FacesContext.getCurrentInstance().isPostback()) {
			this.todosEstados = this.estados.todos();
		}
	}

	public void onEstadoChange() {
		this.cidadesPorEstado = null;

		if (this.estado != null) {
			this.cidadesPorEstado = this.cidades.porEstado(this.estado);
		}

	}

	public void cadastrar() {
		this.fornecedores.adicionar(this.fornecedor);

		this.inicializar();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Cidade> getCidadesPorEstado() {
		return cidadesPorEstado;
	}

	public List<Estado> getTodosEstados() {
		return todosEstados;
	}
	
	public List<Fornecedor> getTodosFornecedores() {
		return todosFornecedores;
	}

}
