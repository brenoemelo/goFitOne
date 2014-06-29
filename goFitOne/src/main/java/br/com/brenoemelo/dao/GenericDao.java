/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brenoemelo.dao;

import br.com.brenoemelo.util.HibernateUtil;
import java.util.Collection;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Breno
 */
public class GenericDao<T> {

    private static Session session;
    private Transaction transaction;

    public void objInsert(T inserted) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.save(inserted);
            session.flush();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void objUpdate(T updated) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(updated);
            session.flush();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void objDelete(T removed) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(removed);
            session.flush();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Collection<T> listAll(Class classe) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        Collection list;
        Criteria selectAll = session.createCriteria(classe);
        transaction.commit();
        list = selectAll.list();
        session.close();
        return list;
    }

    public T find(Class classe, Integer pk) throws Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Object obj = session.load(classe, pk);
            session.flush();
            transaction.commit();
            return (T) obj;
        } finally {
            session.close();
        }
    }
}
