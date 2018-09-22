package fr.dawan.reseauSoc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.dawan.reseauSoc.beans.Likable;

	
public class Dao {
	
	private static EntityManagerFactory eef;
	
	public static EntityManager createEntityManager(String persistenceUnitName) {
		eef= Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em= eef.createEntityManager();
		
		return em;
	}
	
	public static void close() {
		eef.close();
	}

	public static <T extends Likable> void saveOrUpdate(T item) {
		EntityManager em= Dao.createEntityManager("JPA");
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
		em.close();
		Dao.close();
	}

	public <T extends Likable> void delete(T item, EntityManager em) {
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		if(item.getId() != null) {
			em.remove(item);
		}
		tx.commit();
	}
	
	public static <T extends Likable> T findById(Class<T> clazz, int id) {
		EntityManager em= Dao.createEntityManager("JPA");
		T result= null;
		try {
			result=em.find(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		Dao.close();
		return result;
	}
}
