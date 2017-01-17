package br.com.jkavdev.algaworks.javaee.aula403;

import java.math.BigDecimal;
import java.util.Date;

public class Funcionario {

	private Long matricula;
	private String nome;
	private Date dataAdmissao;
	private BigDecimal salario;

	public Funcionario() {

	}

	public Funcionario(Long matricula, String nome, Date dataAdmissao, BigDecimal salario) {

		this.matricula = matricula;
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

}
