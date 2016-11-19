package br.com.jkavdev.algaworks.jpa2.modelos.exercicio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias_produtos")
public class CategoriaProduto extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String nome;
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Produto> produtos = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
