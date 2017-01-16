package br.com.jkavdev.algaworks.javaee.aula216;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "perfilUsuarioAutoCompletePojoBean")
@ViewScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final List<Pais> PAISES = new ArrayList<Pais>();

	static {
		PAISES.add(new Pais(1, "Alemanha"));
		PAISES.add(new Pais(2, "Brasil"));
		PAISES.add(new Pais(3, "Argelia"));
		PAISES.add(new Pais(4, "Belgica"));
		PAISES.add(new Pais(5, "Espanha"));
		PAISES.add(new Pais(6, "Estados Unidos"));
	}

	private String login;
	private Pais pais;

	public List<Pais> sugerirPaises(String consulta) {
		List<Pais> paisesSugeridos = new ArrayList<Pais>();

		for (Pais pais : PAISES) {
			if (pais.getNome().toLowerCase().startsWith(consulta.toLowerCase())) {
				paisesSugeridos.add(pais);
			}
		}

		return paisesSugeridos;
	}

	public void atualizar() {
		System.out.println("Atualizar");
		
		if (this.pais == null) {
			adicionarMensagem("Perfil atualizado sem pais");
		} else {
			adicionarMensagem("Perfil atualizado com pais: " + this.pais.getNome());
		}
	}

	private void adicionarMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}

	public static List<Pais> getPaises() {
		return PAISES;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
