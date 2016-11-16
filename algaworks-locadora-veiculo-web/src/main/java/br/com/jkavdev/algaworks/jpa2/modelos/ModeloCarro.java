package br.com.jkavdev.algaworks.jpa2.modelos;

import javax.persistence.Table;
import javax.persistence.TableGenerator;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "modelos_carros")
@TableGenerator(
		name = Fabricante.TABELA_ID, 
		table = Fabricante.TABELA_ID,
		allocationSize = 20,	
		pkColumnName = Fabricante.TABELA_ID_COLUNA,
		valueColumnName = Fabricante.TABELA_ID_VALOR)
public class ModeloCarro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String descricao;
	private Fabricante fabricante;

	@Id
	@GeneratedValue(generator = Fabricante.TABELA_ID, strategy = GenerationType.TABLE)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "descricao_modelo")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ManyToOne
	@JoinColumn(name = "codigo_fabricante")
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloCarro other = (ModeloCarro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
