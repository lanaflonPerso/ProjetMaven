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
		
		em.close();
		Dao.close();
		return peoples;
	}
	
//	@SuppressWarnings("unchecked")
//	public static PeopleContent SelectById(int id, Session session) {
//		PeopleContent result= null;
//		
//		Criteria criteria = session.createCriteria(PeopleContent.class);
//		Criterion critere = Restrictions.eq("peopleContent_id", id);
//		criteria.add(critere);
//		List<PeopleContent> peoples= (List<PeopleContent>) criteria.list();
//		
//		if (peoples.size() > 0) {
//			result= (PeopleContent) peoples.get(0);
//		}
//		
//		return result;
//	}
}
