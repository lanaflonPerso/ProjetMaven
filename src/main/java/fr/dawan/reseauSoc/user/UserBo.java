package fr.dawan.reseauSoc.user;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;

public class UserBo {
	
	public static User findByEmail(String email) {
		User user= null;
		EntityManager em= Dao.createEntityManager("JPA");
		
		Query query = em.createQuery("SELECT user FROM User user WHERE user.email = :email") ;
		query.setParameter("email",  email);
		
		if(query.getResultList().size() > 0) {
			user = (User) query.getResultList().get(0);
		}
		em.close();
		return user;
	}
}
