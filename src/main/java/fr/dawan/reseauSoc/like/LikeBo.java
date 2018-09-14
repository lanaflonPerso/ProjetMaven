package fr.dawan.reseauSoc.like;

import org.hibernate.Transaction;

import fr.dawan.reseauSoc.dao.Dao;

public class LikeBo extends Dao {
	
	public static int like(int id) {	
		Transaction tx = session().beginTransaction();
		
		String hql = "UPDATE Likable L SET L.likeCount= L.likeCount + 1 WHERE L.id= :id";
		int query = session().createQuery(hql)
			.setInteger("id", id)
			.executeUpdate();
		tx.commit();
		
		return query;
	}
	
	public static int dislike(int id) {
		Transaction tx = session().beginTransaction();
		
		String hql = "UPDATE Likable L SET L.dislikeCount= L.dislikeCount + 1 WHERE L.id= :id";
		int query = session().createQuery(hql)
			.setInteger("id", id)
			.executeUpdate();
		tx.commit();
		
		return query;
	}
}
