package br.com.jkavdev.algaworks.jpa2.modelos.exercicio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String nome;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "codigo_categoria")
	private CategoriaProduto categoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

}
