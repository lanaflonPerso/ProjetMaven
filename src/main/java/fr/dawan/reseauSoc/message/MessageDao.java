package fr.dawan.reseauSoc.message;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.dawan.reseauSoc.beans.Message;
import fr.dawan.reseauSoc.dao.Dao;

public class MessageDao extends Dao {
	
	public static void saveOrUpdate(Message message) {
		EntityManager em= Dao.createEntityManager("JPA");
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
		Dao.close(em);
	}
	
	public static Message findById(int id, EntityManager em) {
		Message result= null;
		try {
			result=em.find(Message.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static List<Message> findAll(int receiverId, EntityManager em) {	
		Query query = em.createQuery("SELECT M FROM Message M WHERE M.receiver.id = :receiverId ORDER BY createdAt DESC", Message.class);
		query.setParameter("receiverId",  receiverId);
		
		List<Message> messages = query.getResultList();
		
		return messages;	
	}
	
	public static void delete(Message message, EntityManager em) {
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		if(message.getId() != null) {
			em.remove(message);
		}
		tx.commit();
	}
	
	public static long countMessage(int receiverId, EntityManager em) {
		Query query = em.createQuery("SELECT COUNT(M.id) FROM Message M WHERE M.receiver.id = :receiverId");
		query.setParameter("receiverId", receiverId);
		long count= (long) query.getSingleResult();
		
		return count;
		
	}
	
}