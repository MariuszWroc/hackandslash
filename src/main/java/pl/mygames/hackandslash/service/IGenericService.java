package pl.mygames.hackandslash.service;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<T, PK extends Serializable> {
	void add(T entity);
	void delete(T entity);
	void update(T entity);
	T findById(PK id);
	List<T> findAll();
	void delete(PK id);
}
