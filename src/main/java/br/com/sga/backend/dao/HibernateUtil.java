package br.com.sga.backend.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static final EntityManagerFactory entityManager = buildSessionFactory();

	private static EntityManagerFactory buildSessionFactory() {
		return Persistence.createEntityManagerFactory("PERSISTENCE_SGA");
	}
	
	public static EntityManager getEntitymanager() {
		return entityManager.createEntityManager();
	}
}
