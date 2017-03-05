package br.com.jkavdev.algaworks.jpa2.modeloslazy;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.jkavdev.algaworks.jpa2.daos.CarroDao;
import br.com.jkavdev.algaworks.jpa2.modelos.Carro;

public class LazyCarroDataModel extends LazyDataModel<Carro> implements Serializable {

	private static final long serialVersionUID = 1L;

	private CarroDao carroDao;

	public LazyCarroDataModel(CarroDao carroDao) {
		this.carroDao = carroDao;
	}

	@Override
	public List<Carro> load(int primeiroRegistro, int totalDeRegistro, String sortField, SortOrder sortOrder,
			Map<String, String> filters) {

		List<Carro> carros = this.carroDao.buscarComPaginacao(primeiroRegistro, totalDeRegistro);
		
		this.setRowCount(this.carroDao.buscarQuantidadeDeCarros().intValue());
		
		return carros;
	}

}
