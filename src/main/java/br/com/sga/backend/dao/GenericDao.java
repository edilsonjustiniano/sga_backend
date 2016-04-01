package br.com.sga.backend.dao;

import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class GenericDao<T, PK> {

	@PersistenceContext
	private EntityManager em;

	public void save(T entity) {
		em.persist(entity);
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public void delete(T entity) {
		em.remove(entity);
	}

	public T getById(PK id) {
		@SuppressWarnings("unchecked")
		T entity = (T) em.find(getTypeClass(), id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query q = em.createQuery(" from " + getTypeClass().getName(), getTypeClass());
		return q.getResultList();
	}

	private Class<?> getTypeClass() {

		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

		return clazz;
	}
}
