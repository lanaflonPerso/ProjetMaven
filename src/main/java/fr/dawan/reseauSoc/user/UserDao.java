package fr.dawan.reseauSoc.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.dawan.reseauSoc.beans.Mur;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;

public class UserDao extends Dao {
	
	public static User findByEmail(String email) {
		EntityManager em= Dao.createEntityManager("JPA");
		User user= null;
		
		Query query = em.createQuery("SELECT user FROM User user WHERE user.email = :email");
		query.setParameter("email",  email);
		
		if(query.getResultList().size() > 0) {
			user = (User) query.getResultList().get(0);
		}
		Dao.close(em);
		return user;
	}
	
	public static User findByIdSimple(int id,EntityManager em) {
		User user= null;
		
		TypedQuery<User> query = em.createQuery("SELECT U FROM User U WHERE U.id = :id", User.class);
		query.setParameter("id",  id);
		
		if(query.getResultList().size() > 0) {
			user = query.getResultList().get(0);
		}
		return user;
	}
	
	public static List<Mur> findBricks(int userId, EntityManager em ) {
		User b = em.find(User.class, userId);
		List<Mur> murs= b.getBricks();
		return murs;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Mur> findMyBricks(int userId, EntityManager em ) {
		Query query = em.createQuery("SELECT M FROM Mur M WHERE M.user.id = :id AND M.share= true ");
		query.setParameter("id",  userId);
		List<Mur> walls= query.getResultList();
		return walls;
	}
}
