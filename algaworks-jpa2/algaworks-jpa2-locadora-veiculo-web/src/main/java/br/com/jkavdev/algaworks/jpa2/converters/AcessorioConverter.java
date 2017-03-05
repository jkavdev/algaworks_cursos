package br.com.jkavdev.algaworks.jpa2.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jkavdev.algaworks.jpa2.daos.AcessorioDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Acessorio;
import br.com.jkavdev.algaworks.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(value = "acessorioConverter", forClass = Acessorio.class)
public class AcessorioConverter implements Converter {

	private AcessorioDao acessorioDao;

	public AcessorioConverter() {
		this.acessorioDao = CDIServiceLocator.getBean(AcessorioDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Acessorio retorno = null;

		if (value != null) {
			retorno = acessorioDao.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Acessorio) value).getCodigo();
			String retorno = codigo == null ? null : codigo.toString();

			return retorno;
		}

		return "";
	}

}
