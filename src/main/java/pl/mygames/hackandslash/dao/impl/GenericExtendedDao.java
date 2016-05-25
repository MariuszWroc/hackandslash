/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

import pl.mygames.hackandslash.dao.IGenericExtendedDao;

/**
 *
 * @author Mariusz
 * @param <T>
 * @param <PK>
 */
public abstract class GenericExtendedDao<T, PK extends Serializable> implements IGenericExtendedDao<T, PK> {
    private static final Logger logger = LoggerFactory.getLogger(GenericExtendedDao.class);
    private final Class<T> type;
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public GenericExtendedDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }
    
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Class<T> getType() {
        return this.type;
    }

    protected String getClassName() {
        return type.getName();
    }



    @Override
    public void flushSession() {
        getSession().flush();
        logger.info("flush");
    }

    @Override
    public void clearSession() {
        getSession().clear();
        logger.info("clear");
    }

    @Override
    public void refresh(T entity) {
        getSession().refresh(entity);
        logger.info("refresh");
    }

    @Override
    public void add(T entity) {
        getSession().save(entity);
        logger.info("save " + entity.getClass().getSimpleName());
    }

    @Override
    public void merge(T entity) {
        getSession().merge(entity);
        logger.info("merge " + entity.getClass().getSimpleName());
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
        logger.info("delete " + entity.getClass().getSimpleName());
    }
    
    @Override
    public void delete(PK id) {
		T entityToDelete = get(id);
        if(entityToDelete != null){
            delete(entityToDelete);
        }
    }

    @Override
    public void update(T entity) {
    	getSession().flush();
        getSession().update(entity);
        logger.info("update " + entity.getClass().getSimpleName());
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
        logger.info("saveOrUpdate " + entity.getClass().getSimpleName());
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public T get(PK id) {
        return (T) getSession().load(type, id);
    }

    @Override
    @Deprecated
    public T findById(PK id) throws DataAccessException {
        T found = type.cast(getSession().byId(type));
        if (found == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return found;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByQuery(String namedQuery) {
        logger.info("Find by query: " + namedQuery);
        return getSession().getNamedQuery(namedQuery).list();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<T> findByQuery(String namedQuery, Integer number) {
        logger.info("Find by query: " + namedQuery + ", id = " + number);
		return getSession().getNamedQuery(namedQuery).setInteger("id", number).list();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<T> findByQuery(String namedQuery, String paramName, String paramValue) {
        logger.info("Find by query: " + namedQuery + ", where + " + paramName + " = " + paramValue);
		return getSession().getNamedQuery(namedQuery).setString(paramName, paramValue).list();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        logger.info("Find all by criteria");
        return getSession().createCriteria(type).list();
    }
    
    @Override
    public Long count() {
        logger.info("count");
        Long count = (Long) getSession().createCriteria(type)
                .setProjection(Projections.rowCount())
                .uniqueResult();
        if(count == null) {
            return 0L;
        }
        else {
            return count;
        }
    }
    
    @Override
    public Integer generateId() {
    	return count().intValue() + 1;
    }
}
