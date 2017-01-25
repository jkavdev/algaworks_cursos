package br.com.jkavdev.algaworks.javaee.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jkavdev.algaworks.javaee.model.Pedido;
import br.com.jkavdev.algaworks.javaee.repository.Pedidos;
import br.com.jkavdev.algaworks.javaee.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Pedido.class)
public class PedidoConverter implements Converter {

	private Pedidos pedidos;

	public PedidoConverter() {
		this.pedidos = CDIServiceLocator.getBean(Pedidos.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pedido retorno = null;

		if (value != null) {
			System.out.println("getAsObject....");
			retorno = pedidos.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Pedido) value).getId();
			String retorno = codigo == null ? null : codigo.toString();

			return retorno;
		}

		return "";
	}

}
