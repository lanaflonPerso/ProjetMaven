package fr.dawan.reseauSoc.main;

import javax.persistence.EntityManager;

import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;

public class AddUser {
	
	public static void saveUser() {
		EntityManager em= Dao.createEntityManager("JPA");
		Dao dao= new Dao();
		dao.saveOrUpdate(getVianneyBailleux(), em, false);
		dao.saveOrUpdate(getSteveHarris() , em, false);
		dao.saveOrUpdate(getPaulStanley(), em, false);
		dao.saveOrUpdate(getBruceDickinson(), em, false);
		dao.saveOrUpdate(getRobHalford(), em, false);
		dao.saveOrUpdate(getGeneSimmons(), em, false);
		dao.saveOrUpdate(getPeterCarr(), em, false);
		em.close();
	}
	
	public static User getVianneyBailleux() {
		User user =new User();
		user.setFirstName("Vianney");
		user.setLastName("Bailleux");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
	public static User getSteveHarris() {
		User user =new User();
		user.setFirstName("Steve");
		user.setLastName("Harris");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
	public static User getPaulStanley() {
		User user =new User();
		user.setFirstName("Paul");
		user.setLastName("Stanley");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
	
	public static User getBruceDickinson() {
		User user =new User();
		user.setFirstName("Bruce");
		user.setLastName("Dickinson");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
	public static User getRobHalford() {
		User user =new User();
		user.setFirstName("Rob");
		user.setLastName("Halford");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
	public static User getGeneSimmons() {
		User user =new User();
		user.setFirstName("Gene");
		user.setLastName("Simmons");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
	public static User getPeterCarr() {
		User user =new User();
		user.setFirstName("Peter");
		user.setLastName("Carr");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
}