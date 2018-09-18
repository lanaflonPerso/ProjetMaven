package fr.dawan.reseauSoc.people;

import javax.persistence.EntityManager;

import fr.dawan.reseauSoc.beans.PeopleContent;
import fr.dawan.reseauSoc.dao.Dao;

public class PeopleContentBo extends Dao {
		
	public static PeopleContent findById(int id) {
		EntityManager em= Dao.createEntityManager("JPA");
		Dao dao= new Dao();
		return dao.findById(PeopleContent.class, id, em, false);
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
