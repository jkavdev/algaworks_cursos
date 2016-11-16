package br.com.jkavdev.algaworks.jpa2.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jkavdev.algaworks.jpa2.daos.ModeloCarroDao;
import br.com.jkavdev.algaworks.jpa2.modelos.ModeloCarro;
import br.com.jkavdev.algaworks.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = ModeloCarro.class)
public class ModeloCarroConverter implements Converter {

	private ModeloCarroDao modeloCarroDao;

	public ModeloCarroConverter() {
		this.modeloCarroDao = CDIServiceLocator.getBean(ModeloCarroDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ModeloCarro retorno = null;

		if (value != null) {
			retorno = modeloCarroDao.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((ModeloCarro) value).getCodigo();
			String retorno = codigo == null ? null : codigo.toString();

			return retorno;
		}

		return "";
	}

}
