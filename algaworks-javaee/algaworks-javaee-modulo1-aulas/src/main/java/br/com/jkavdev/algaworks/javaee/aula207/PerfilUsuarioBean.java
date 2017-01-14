package br.com.jkavdev.algaworks.javaee.aula207;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "perfilUsuarioTextAreaBean")
@ViewScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String sobre;

	public void atualizar() {
		System.out.println("Sobre: " + this.sobre);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfíl atulizado"));
	}

	public List<String> completarTexto(String consulta) {
		List<String> resultados = new ArrayList<String>();

		if (consulta.startsWith("thi")) {
			resultados.add("Thiago");
			resultados.add("Thiago Cezar");
			resultados.add("Thiago Farias");
			resultados.add("Thiago Marlos");
			resultados.add("Thiago Mendes");
		}

		return resultados;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
}
