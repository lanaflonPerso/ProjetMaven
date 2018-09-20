package fr.dawan.reseauSoc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.dawan.reseauSoc.beans.Likable;

public class Dao {
	
	public static EntityManager createEntityManager(String persistenceUnitName) {
		EntityManagerFactory eef= Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em= eef.createEntityManager();
		
		return em;
	}

	public static <T extends Likable> void saveOrUpdate(T item, EntityManager em) {
		EntityTransaction tx= em.getTransaction();
		try {
			tx.begin();
			if (item.getId() == null ) {
				em.persist(item);
			} else {
				em.merge(item);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public <T extends Likable> void delete(T item, EntityManager em) {
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		if(item.getId() != null) {
			em.remove(item);
		}
		tx.commit();
	}
	
	public static <T extends Likable> T findById(Class<T> clazz, int id, EntityManager em) {
		T result= null;
		try {
			result=em.find(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
