package br.com.jkavdev.algaworks.javaee.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

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
import br.com.jkavdev.algaworks.javaee.validation.SKU;

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
	private String sku;

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
	
	public void carregarProdutoPorSku(){
		if(StringUtils.isNotEmpty(this.sku)){
			this.produtoLinhaEditavel = this.produtos.porSku(this.sku);
			this.carregarProdutoLinhaEditavel();
		}
	}
	
	public void carregarProdutoLinhaEditavel() {
		// Retorna primeiro pedido
		ItemPedido item = this.pedido.getItens().get(0);

		if (this.produtoLinhaEditavel != null) {
			if(this.existeItemComProduto(this.produtoLinhaEditavel)){
				FacesUtil.addErrorMessagem("Já existe um item no pedido com o produto informado.");
			} else {
				// Adiciona relacionamento entre pedido e produto
				item.setProduto(this.produtoLinhaEditavel);
				item.setValorUnitario(this.produtoLinhaEditavel.getValorUnitario());
	
				// Adiciona um novo item e atribui null ao produto
				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;
				this.sku = null;
	
				// Recalcula valor do pedido
				this.pedido.recalcularValorTotal();
			}
		}
	}
	
	private boolean existeItemComProduto(Produto produto) {
		boolean existeItem = false;

		for (ItemPedido item : this.getPedido().getItens()) {
			if (produto.equals(item.getProduto())) {
				existeItem = true;
				break;
			}
		}

		return existeItem;
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

	@SKU
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public List<Usuario> getVendedores() {
		return vendedores;
	}

	public boolean isEditando() {
		return this.pedido.getId() != null;
	}

}
