package br.com.jkavdev.algaworks.jpa2.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa {

	private Long codigo;
	private String nome;
	private List<Telefone> telefones = new ArrayList<>();

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ElementCollection
	@CollectionTable(
			name = "pessoa_telefones",
			joinColumns = @JoinColumn(name = "codigo_pessoa"))
	@AttributeOverrides({
		@AttributeOverride(name = "numero", column = @Column(name = "numero_telefone")),
		@AttributeOverride(name = "ramal", column = @Column(name = "ramal_telefone")),
		@AttributeOverride(name = "prefixo", column = @Column(name = "prefixo_telefone")),
	})
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

}
