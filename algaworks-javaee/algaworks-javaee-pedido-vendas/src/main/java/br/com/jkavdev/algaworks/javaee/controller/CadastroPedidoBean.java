package br.com.jkavdev.algaworks.javaee.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.javaee.model.Cliente;
import br.com.jkavdev.algaworks.javaee.model.FormaPagamento;
import br.com.jkavdev.algaworks.javaee.model.ItemPedido;
import br.com.jkavdev.algaworks.javaee.model.Pedido;
import br.com.jkavdev.algaworks.javaee.model.Produto;
import br.com.jkavdev.algaworks.javaee.model.Usuario;
import br.com.jkavdev.algaworks.javaee.repository.Clientes;
import br.com.jkavdev.algaworks.javaee.repository.Produtos;
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
	private Produtos produtos;
	@Inject
	private CadastroPedidoService cadastroPedidoService;

	private Pedido pedido;
	private Produto produtoLinhaEditavel;

	private List<Usuario> vendedores;

	public CadastroPedidoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostBack()) {
			vendedores = usuarios.vendedores();
			
			this.pedido.adicionarItemVazio();

			// Resolvendo problema do lazy em itens
			recalcularPedido();
		}
	}

	private void limpar() {
		pedido = new Pedido();
	}

	public void salvar() {
		pedido = cadastroPedidoService.salvar(pedido);

		FacesUtil.addInfoMessagem("Pedido salvo com sucesso!");
	}

	public void recalcularPedido() {
		// Será calculado o valor apenas quando criado o pedido
		if (this.pedido != null) {
			this.pedido.recalcularValorTotal();
		}
	}
	
	public void carregarProdutoLinhaEditavel() {
		// Retorna primeiro pedido
		ItemPedido item = this.pedido.getItens().get(0);

		if (this.produtoLinhaEditavel != null) {
			// Adiciona relacionamento entre pedido e produto
			item.setProduto(this.produtoLinhaEditavel);
			item.setValorUnitario(this.produtoLinhaEditavel.getValorUnitario());

			// Adiciona um novo item e atribui null ao produto
			this.pedido.adicionarItemVazio();
			this.produtoLinhaEditavel = null;

			// Recalcula valor do pedido
			this.pedido.recalcularValorTotal();
		}
	}
	
	public List<Produto> completarProduto(String nome){
		return this.produtos.porNome(nome);
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

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}
	
	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}

	public List<Usuario> getVendedores() {
		return vendedores;
	}

	public boolean isEditando() {
		return this.pedido.getId() != null;
	}

}
