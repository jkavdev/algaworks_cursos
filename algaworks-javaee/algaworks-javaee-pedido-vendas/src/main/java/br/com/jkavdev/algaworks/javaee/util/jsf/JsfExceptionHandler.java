package br.com.jkavdev.algaworks.javaee.util.jsf;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class JsfExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapper;

	public JsfExceptionHandler(ExceptionHandler wrapper) {
		this.wrapper = wrapper;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapper;
	}

	@Override
	public void handle() throws FacesException {
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();

		while (events.hasNext()) {
			ExceptionQueuedEvent event = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

			Throwable exception = context.getException();

			try {
				if (exception instanceof ViewExpiredException) {
					redirect("/");
				}
			} finally {
				events.remove();
			}
		}

		// 'Passando a vez' para o tratador de exceptions do JSF
		getWrapped().handle();
	}

	private void redirect(String pagina) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext externalContext = context.getExternalContext();
			String contextPath = externalContext.getRequestContextPath();

			externalContext.redirect(contextPath + pagina);
		} catch (IOException e) {
			throw new FacesException(e);
		}
	}

}
