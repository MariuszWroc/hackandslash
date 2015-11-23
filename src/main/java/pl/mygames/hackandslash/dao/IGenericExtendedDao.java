/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Mariusz
 * @param <T>
 * @param <PK>
 */
public interface IGenericExtendedDao<T, PK extends Serializable> {
    List<T> findAll();
    
    void flushSession();

    void clearSession();
            
    void refresh(T entity);

    void add(T entity) throws DataAccessException;
    
    void merge(T entity) throws DataAccessException;

    void delete(T entity) throws DataAccessException;

    void update(T entity) throws DataAccessException;
    
    void saveOrUpdate(T entity) throws DataAccessException;

    T findById(PK id) throws EmptyResultDataAccessException;

    Long count() throws EmptyResultDataAccessException; 
    
    Integer generateId();

	T get(PK id);

	void delete(PK id);

	List<T> findByQuery(String namedQuery);

	List<T> findByQuery(String namedQuery, Integer id);

	List<T> findByQuery(String namedQuery, String string);

}
