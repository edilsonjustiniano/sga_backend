package br.com.sga.backend.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDao<T, PK> {

	protected EntityManager em;

	public GenericDao(EntityManager em) {
		this.em = em;
	}

	public void save(T entity) {

		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public void update(T entity) {

		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	public void delete(T entity) {

		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
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
