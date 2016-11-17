package com.algaworks.jboss.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.algaworks.jboss.ejb.CadastroClienteEJB;
import com.algaworks.jboss.modelo.Cliente;

@Named
@SessionScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private CadastroClienteEJB cadastroClienteEJB;

	private Cliente cliente;
	private List<Cliente> clientes;

	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
		this.clientes = this.cadastroClienteEJB.buscarTodos();
	}

	public void salvar() {
		this.cadastroClienteEJB.salvar(cliente);
		
		this.init();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

}
