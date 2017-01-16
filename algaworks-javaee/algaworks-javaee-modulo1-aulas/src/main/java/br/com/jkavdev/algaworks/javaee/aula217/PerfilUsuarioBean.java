package br.com.jkavdev.algaworks.javaee.aula217;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "perfilUsuarioMaskBean")
@ViewScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String celular;
	private String telefoneComercial;
	private String matricula;

	public void atualizar() {
		System.out.println("Celular: " + this.celular);
		System.out.println("Telefone comercial: " + this.telefoneComercial);
		System.out.println("Matricula: " + this.matricula);

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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
