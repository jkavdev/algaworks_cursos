package br.com.jkavdev.algaworks.javaee.aula211;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "perfilUsuarioCustomOneSelectBean")
@ViewScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final List<Interesse> INTERESSES = new ArrayList<Interesse>();

	static {
		INTERESSES.add(new Interesse("Esportes", "esportes"));
		INTERESSES.add(new Interesse("Computação", "computacao"));
		INTERESSES.add(new Interesse("Cinema", "cinema"));
		INTERESSES.add(new Interesse("Leitura", "leitura"));
	}

	private String login;
	private Interesse interesse;

	public void atualizar() {
		System.out.println("Interesse: " + this.interesse.getDescricao());

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}

	public List<Interesse> getInteresses() {
		return INTERESSES;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Interesse getInteresse() {
		return interesse;
	}

	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}

}
