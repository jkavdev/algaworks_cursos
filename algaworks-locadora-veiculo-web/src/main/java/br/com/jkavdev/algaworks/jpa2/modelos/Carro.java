package br.com.jkavdev.algaworks.jpa2.modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "carros")
@NamedQueries({
	@NamedQuery(name = "Carro.buscarTodos", query = "select c from Carro c inner join fetch c.modeloCarro"),
	@NamedQuery(name = "Carro.buscarCarroComAcessorios", query = "select c from Carro c join c.acessorios where c.codigo = :codigo")
})
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String placa;
	private String cor;
	private BigDecimal valorDiaria;
	private ModeloCarro modeloCarro;	
	private List<Acessorio> acessorios;
	private List<Aluguel> alugueis;
	
	private Date dataCriacao;
	private Date dataModificao;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Column(name = "valor_diaria")
	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_modelo")
	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "carro_acessorios", 
			joinColumns = @JoinColumn(name = "codigo_carro"), 
			inverseJoinColumns = @JoinColumn(name = "codigo_acessorio"))
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	@OneToMany(mappedBy = "carro")
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao")
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_modificao")
	public Date getDataModificao() {
		return dataModificao;
	}

	public void setDataModificao(Date dataModificao) {
		this.dataModificao = dataModificao;
	}
	
	@PrePersist
	@PreUpdate
	public void configuraDatasCriacaoEAlteracao(){
		this.dataModificao = new Date();
		
		if(this.dataCriacao == null){
			this.dataCriacao = new Date();
		}
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
		Carro other = (Carro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
