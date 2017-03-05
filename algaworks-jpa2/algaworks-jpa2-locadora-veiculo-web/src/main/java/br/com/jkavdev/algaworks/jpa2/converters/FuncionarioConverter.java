package br.com.jkavdev.algaworks.jpa2.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jkavdev.algaworks.jpa2.daos.FuncionarioDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Funcionario;
import br.com.jkavdev.algaworks.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConverter implements Converter {

	private FuncionarioDao funcionarioDao;

	public FuncionarioConverter() {
		this.funcionarioDao = CDIServiceLocator.getBean(FuncionarioDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Funcionario retorno = null;

		if (value != null) {
			retorno = funcionarioDao.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Funcionario) value).getCodigo();
			String retorno = codigo == null ? null : codigo.toString();

			return retorno;
		}

		return "";
	}

}
