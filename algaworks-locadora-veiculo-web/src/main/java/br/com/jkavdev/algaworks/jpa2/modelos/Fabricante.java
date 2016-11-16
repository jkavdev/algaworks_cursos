package br.com.jkavdev.algaworks.jpa2.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "fabricantes")
@TableGenerator(
		name = Fabricante.TABELA_ID, 
		table = Fabricante.TABELA_ID,
		allocationSize = 20,	
		pkColumnName = "entidade",
		valueColumnName = "alocacao")
public class Fabricante implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String TABELA_ID = "tabela_de_ids";

	private Long codigo;
	private String nome;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = TABELA_ID)
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

}
