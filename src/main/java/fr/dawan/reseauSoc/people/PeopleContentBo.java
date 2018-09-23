package fr.dawan.reseauSoc.people;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.reseauSoc.beans.PeopleContent;
import fr.dawan.reseauSoc.dao.Dao;

public class PeopleContentBo extends Dao {
		
//	public static PeopleContent findById(int id) {
//		EntityManager em= Dao.createEntityManager("JPA");
//		Dao dao= new Dao();
//		return dao.findById(PeopleContent.class, id, em);
//	}
	
	@SuppressWarnings("unchecked")
	public static List<PeopleContent> findByLastName(String lastName, EntityManager em) {
		Query query = em.createQuery("SELECT people FROM PeopleContent people WHERE people.lastName LIKE :name") ;
		query.setParameter("name",  "%"+lastName+"%");
		
		List<PeopleContent> peoples= query.getResultList();
		
		return peoples;	
	}
	
	public static PeopleContent findByName(String firstName, String lastName) {
		EntityManager em= Dao.createEntityManager("JPA");
		
		PeopleContent peoples= null;
		Query query = em.createQuery("SELECT P FROM PeopleContent P WHERE P.lastName= :lastName AND P.firstName= :firstName ") ;
		query.setParameter("lastName",  lastName);
		query.setParameter("firstName",  firstName);
		
		if( query.getResultList().size() > 0) {
			peoples= (PeopleContent) query.getResultList().get(0);
		}
		
		Dao.close(em);
		return peoples;
	}
}