package fr.dawan.reseauSoc.bo;

import org.hibernate.Query;

import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;

public class UserBo extends Dao{
	protected static User user = null;
	
	public static User findByEmail(String email) {
		String hql = "SELECT u FROM User u WHERE u.email = :email";
		Query query = session().createQuery(hql)
			.setParameter("email", email);
		if(query.list().size() > 0) {
			user = (User) query.list().get(0);	
		}
		return user;
	}
}
