package br.com.jkavdev.algaworks.javaee.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.jkavdev.algaworks.javaee.model.Pedido;
import br.com.jkavdev.algaworks.javaee.repository.filter.PedidoFilter;

public class Pedidos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Pedido guardar(Pedido pedido) {
		return manager.merge(pedido);
	}

	@SuppressWarnings("unchecked")
	public List<Pedido> filtrados(PedidoFilter filtro) {
		Session session = manager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(Pedido.class)
				.createAlias("cliente", "c")
				.createAlias("vendedor", "v");

		if (filtro.getNumeroDe() != null) {
			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}

		if (filtro.getNumeroAte() != null) {
			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}

		if (filtro.getDataCriacaoDe() != null) {
			criteria.add(Restrictions.ge("dataCricao", filtro.getDataCriacaoDe()));
		}

		if (filtro.getDataCriacaoAte() != null) {
			criteria.add(Restrictions.le("dataCricao", filtro.getDataCriacaoAte()));
		}

		if (StringUtils.isNotBlank(filtro.getNomeCliente())) {
			criteria.add(Restrictions.ilike("c.nome", filtro.getNomeCliente(), MatchMode.ANYWHERE));
		}

		if (StringUtils.isNotBlank(filtro.getNomeVendedor())) {
			criteria.add(Restrictions.ilike("v.nome", filtro.getNomeVendedor(), MatchMode.ANYWHERE));
		}

		if (filtro.getStatuses() != null && filtro.getStatuses().length > 0) {
			criteria.add(Restrictions.in("status", filtro.getStatuses()));
		}

		return criteria.addOrder(Order.asc("id")).list();
	}

}
