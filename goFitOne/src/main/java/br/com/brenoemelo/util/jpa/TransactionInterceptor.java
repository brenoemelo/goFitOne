/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brenoemelo.util.jpa;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

/**
 *
 * @author Breno
 */
@Interceptor
@Transactional
public class TransactionInterceptor {

    private static final long serialVersionUID = 1L;

    private @Inject
    EntityManager manager;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        EntityTransaction transaction = manager.getTransaction();
        boolean owner = false;

        try {
            if (!transaction.isActive()) {
                // truque para fazer rollback no que já passou
                // (senão, um futuro commit, confirmaria até mesmo operações sem transação)
                transaction.begin();
                transaction.rollback();

                // agora sim inicia a transaÃ§Ã£o
                transaction.begin();

                owner = true;
            }

            return context.proceed();
        } catch (Exception e) {
            if (transaction != null && owner) {
                transaction.rollback();
            }

            throw e;
        } finally {
            if (transaction != null && transaction.isActive() && owner) {
                transaction.commit();
            }
        }
    }
}
