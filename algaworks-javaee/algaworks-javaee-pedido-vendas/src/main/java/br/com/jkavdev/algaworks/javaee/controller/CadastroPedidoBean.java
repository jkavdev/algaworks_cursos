package br.com.jkavdev.algaworks.javaee.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.model.Cliente;
import br.com.jkavdev.algaworks.javaee.model.FormaPagamento;
import br.com.jkavdev.algaworks.javaee.model.Pedido;
import br.com.jkavdev.algaworks.javaee.model.Usuario;
import br.com.jkavdev.algaworks.javaee.repository.Clientes;
import br.com.jkavdev.algaworks.javaee.repository.Usuarios;
import br.com.jkavdev.algaworks.javaee.service.CadastroPedidoService;
import br.com.jkavdev.algaworks.javaee.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;
	@Inject
	private Clientes clientes;
	@Inject
	private CadastroPedidoService cadastroPedidoService;

	private Pedido pedido;

	private List<Usuario> vendedores;

	public CadastroPedidoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			vendedores = usuarios.vendedores();
		}
	}

	private void limpar() {
		pedido = new Pedido();
	}

	public void salvar() {
		pedido = cadastroPedidoService.salvar(pedido);

		FacesUtil.addInfoMessagem("Pedido salvo com sucesso!");
	}

	public FormaPagamento[] getFormasPagamento() {
		return FormaPagamento.values();
	}

	public List<Cliente> completarCliente(String nome) {
		return clientes.porNome(nome);
	}

	public Pedido getPedido() {
		return pedido;
	}

	public List<Usuario> getVendedores() {
		return vendedores;
	}

}
