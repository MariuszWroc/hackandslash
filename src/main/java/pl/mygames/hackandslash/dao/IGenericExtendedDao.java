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
    List<T> findAll() throws EmptyResultDataAccessException;
    
    void flushSession();

    void clearSession();
            
    void refresh(T entity) throws DataAccessException;

    void add(T entity) throws DataAccessException;
    
    void merge(T entity) throws DataAccessException;

    void delete(T entity) throws DataAccessException;

    void update(T entity) throws DataAccessException;
    
    void saveOrUpdate(T entity) throws DataAccessException;

    T findById(PK id) throws EmptyResultDataAccessException;

    Long count() throws EmptyResultDataAccessException; 
    
    Integer generateId();

	T get(PK id) throws EmptyResultDataAccessException;

	void delete(PK id) throws DataAccessException;

	List<T> findByQuery(String namedQuery) throws EmptyResultDataAccessException;

	List<T> findByQuery(String namedQuery, Integer id) throws EmptyResultDataAccessException;

	List<T> findByQuery(String namedQuery, String paramName, String paramValue) throws EmptyResultDataAccessException;

}
