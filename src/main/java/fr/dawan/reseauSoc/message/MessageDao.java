package fr.dawan.reseauSoc.message;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.dawan.reseauSoc.beans.Message;
import fr.dawan.reseauSoc.dao.Dao;

public class MessageDao extends Dao {
	
	public static void saveOrUpdate(Message message, EntityManager em) {
		EntityTransaction tx= em.getTransaction();
		try {
			tx.begin();
			if (message.getId() == null ) {
				em.persist(message);
			} else {
				em.merge(message);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
