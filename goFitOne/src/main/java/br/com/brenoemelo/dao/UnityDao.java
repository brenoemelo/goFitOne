/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brenoemelo.dao;

import br.com.brenoemelo.model.Unity;
import br.com.brenoemelo.util.exceptions.ApplException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

/**
 *
 * @author Breno
 */
public class UnityDao implements Serializable, BasicDAO<Unity> {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    @Override
    public void save(Unity inserted) {
        manager.merge(inserted);
    }

    @Override
    public void update(Unity updated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void delete(Unity removed) throws ApplException {
        removed = searchById(removed.getUnityId());
        try {
            manager.remove(removed);
            manager.flush();
        } catch (PersistenceException e) {
            throw new ApplException("The unity cannot be removed.");
        }
    }

    @Override
    public List<Unity> searchAll() {
        return manager.createNamedQuery("Unity.findAll").getResultList();
    }

    @Override
    public Unity searchById(Integer id) {
        return manager.find(Unity.class, id);
    }

}
