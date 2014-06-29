/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brenoemelo.dao;

import br.com.brenoemelo.util.exceptions.ApplException;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Breno Melo
 * @param <T> The class type to use in the DAO
 */
public interface BasicDAO<T> {

    //Basic CRUD
    public void save(T inserted);

    public void update(T updated);

    @Transactional
    public void delete(T removed) throws ApplException;

    //Basic Search
    public List<T> searchAll();

    public T searchById(Integer id);

}
