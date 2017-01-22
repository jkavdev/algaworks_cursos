package br.com.jkavdev.algaworks.javaee.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static boolean isPostBack() {
		return FacesContext.getCurrentInstance().isPostback();
	}

	public static boolean isNotPostBack() {
		return !isPostBack();
	}

	public static void addErrorMessagem(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	public static void addInfoMessagem(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}

}
