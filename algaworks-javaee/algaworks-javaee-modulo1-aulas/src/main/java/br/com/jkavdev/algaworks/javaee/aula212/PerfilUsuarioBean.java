package br.com.jkavdev.algaworks.javaee.aula212;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "perfilUsuarioAjaxOneSelectBean")
@ViewScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> estados = new ArrayList<String>();
	private List<String> cidades = new ArrayList<String>();

	public PerfilUsuarioBean() {
		estados.add("MG");
		estados.add("RJ");
		estados.add("SP");
	}

	private String nome;
	private String estado;
	private String cidade;

	public void carregarCidades() {
		cidades.clear();

		if ("MG".equals(estado)) {
			cidades.add("Uberlândia");
			cidades.add("Uberaba");
			cidades.add("Belo Horizonte");
		} else if ("RJ".equals(estado)) {
			cidades.add("Rio de Janeiro");
			cidades.add("Copacabana");
		} else if ("SP".equals(estado)) {
			cidades.add("São Paulo");
			cidades.add("Copacabana");
		}
	}
	
	public void atualizar() {
		System.out.println("Estado: " + this.estado);
		System.out.println("Cidade: " + this.cidade);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}

	public List<String> getEstados() {
		return estados;
	}

	public List<String> getCidades() {
		return cidades;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
