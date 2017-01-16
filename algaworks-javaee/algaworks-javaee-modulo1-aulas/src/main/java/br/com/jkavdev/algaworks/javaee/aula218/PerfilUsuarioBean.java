package br.com.jkavdev.algaworks.javaee.aula218;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "perfilUsuarioBooleanBean")
@ViewScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private Boolean aceito;

	public void atualizar() {
		System.out.println("Aceito: " + this.aceito);

		adicionarMensagem("Atualizado com sucesso");
	}

	private void adicionarMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getAceito() {
		return aceito;
	}

	public void setAceito(Boolean aceito) {
		this.aceito = aceito;
	}

}
