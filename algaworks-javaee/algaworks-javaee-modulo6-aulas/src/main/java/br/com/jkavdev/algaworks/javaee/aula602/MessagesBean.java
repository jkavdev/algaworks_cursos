package br.com.jkavdev.algaworks.javaee.aula602;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class MessagesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public void adicionarMensagemErro(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
				"Resumo mensagem de erro", "Mensagem complete de erro");
		
		context.addMessage("destinoErro", message);
	}
	
	public void adicionarMensagemAviso(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, 
				"Resumo mensagem de aviso", "Mensagem complete de aviso");
		
		context.addMessage("destinoAviso", message);
	}

}
