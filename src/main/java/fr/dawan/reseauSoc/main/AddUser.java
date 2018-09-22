package fr.dawan.reseauSoc.main;

import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;

public class AddUser {
	
	public static void saveUser() {
		Dao.saveOrUpdate(getVianneyBailleux());
		Dao.saveOrUpdate(getSteveHarris());
		Dao.saveOrUpdate(getPaulStanley());
		Dao.saveOrUpdate(getBruceDickinson());
		Dao.saveOrUpdate(getRobHalford());
		Dao.saveOrUpdate(getGeneSimmons());
		Dao.saveOrUpdate(getPeterCarr());
	}
	
	public static User getVianneyBailleux() {
		User user =new User();
		user.setType("user");
		user.setFirstName("Vianney");
		user.setLastName("Bailleux");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
	public static User getSteveHarris() {
		User user =new User();
		user.setType("user");
		user.setFirstName("Steve");
		user.setLastName("Harris");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
	public static User getPaulStanley() {
		User user =new User();
		user.setType("user");
		user.setFirstName("Paul");
		user.setLastName("Stanley");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
	
	public static User getBruceDickinson() {
		User user =new User();
		user.setType("user");
		user.setFirstName("Bruce");
		user.setLastName("Dickinson");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
	public static User getRobHalford() {
		User user =new User();
		user.setType("user");
		user.setFirstName("Rob");
		user.setLastName("Halford");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
	public static User getGeneSimmons() {
		User user =new User();
		user.setType("user");
		user.setFirstName("Gene");
		user.setLastName("Simmons");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		
		return user;
	}
	
	public static User getPeterCarr() {
		User user =new User();
		user.setType("user");
		user.setFirstName("Peter");
		user.setLastName("Carr");
		user.setPassword("a");
		user.setEmail(user.getLastName()+"@free.fr");
		return user;
	}
	
}
