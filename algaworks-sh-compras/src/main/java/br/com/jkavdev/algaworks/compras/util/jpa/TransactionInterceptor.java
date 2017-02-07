package br.com.jkavdev.algaworks.compras.util.jpa;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Priority(Interceptor.Priority.LIBRARY_BEFORE)
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction transaction = this.manager.getTransaction();
		boolean criador = false;

		try {
			if (!transaction.isActive()) {
				// Truque para realizar o rollback no que já passou
				transaction.begin();
				transaction.rollback();

				transaction.begin();
				criador = true;
			}

			return context.proceed();
		} catch (Exception e) {
			if (transaction != null && criador) {
				transaction.rollback();
			}

			throw e;
		} finally {
			if (transaction != null && transaction.isActive() && criador) {
				transaction.commit();
			}
		}
	}

}
