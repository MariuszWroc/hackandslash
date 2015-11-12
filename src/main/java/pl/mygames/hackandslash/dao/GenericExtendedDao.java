/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Mariusz
 * @param <T>
 * @param <PK>
 */
public abstract class GenericExtendedDao<T, PK extends Serializable> implements IGenericExtendedDao<T, PK> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private final Class<T> type;

    protected Class<T> getType() {
        return this.type;
    }

    protected String getClassName() {
        return type.getName();
    }

    @SuppressWarnings("unchecked")
    public GenericExtendedDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public void flushSession() {
        getSession().flush();
    }

    @Override
    public void clearSession() {
        getSession().clear();
    }

    @Override
    public void refresh(T entity) {
        getSession().refresh(entity);
    }

    @Override
    public void add(T entity) {
        getSession().save(entity);
    }

    @Override
    public void merge(T entity) {
        getSession().merge(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }
    
    @Override
    public T get(PK id) {
        return (T) type.cast(getSession().load(type, id));
    }

    @Override
    public T findById(PK id) throws DataAccessException {
        T found = type.cast(getSession().byId(type));
        if (found == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return found;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByQuery(String query) {
        List<T> listObjects = getSession().createQuery(query).list();
        return listObjects;
    }
    
     /**
     * Find all entities
     * @return
     */
    @Override
    public List<T> findAll() {
        return getSession().createCriteria(type).list();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAllByCriteria() {
        Criteria criteria = getSession().createCriteria(type);
        List<T> list = criteria.list();
        return list;
    }
    
    
    @Override
    public Integer count() {
        Integer count = (Integer)getSession().createCriteria(type)
                .setProjection(Projections.rowCount())
                .uniqueResult();
        if(count == null) {
            return (Integer)0;
        }
        else {
            return count;
        }
    }
    
    @Override
    public Integer generateId() {
	return count() + 1;
    }
}
