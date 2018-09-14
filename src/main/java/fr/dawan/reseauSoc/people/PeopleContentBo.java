package fr.dawan.reseauSoc.people;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import fr.dawan.reseauSoc.beans.PeopleContent;
import fr.dawan.reseauSoc.dao.Dao;

public class PeopleContentBo extends Dao {
		
	public static PeopleContent SelectByName(String firstName, String lastName) {
		PeopleContent people= null;
		
		Criteria criteria = session().createCriteria(PeopleContent.class);
		Criterion critere = Restrictions.eq("firstName", firstName);
		Criterion critere2 = Restrictions.eq("lastName", lastName);
		criteria.add(critere).add(critere2);
		
		if(criteria.list().size() > 0) {
			people= (PeopleContent) criteria.list().get(0);
		}
		return people;
	}
	
	@SuppressWarnings("unchecked")
	public static PeopleContent SelectById(int id, Session session) {
		PeopleContent result= null;
		
		Criteria criteria = session.createCriteria(PeopleContent.class);
		Criterion critere = Restrictions.eq("peopleContent_id", id);
		criteria.add(critere);
		List<PeopleContent> peoples= (List<PeopleContent>) criteria.list();
		
		if (peoples.size() > 0) {
			result= (PeopleContent) peoples.get(0);
		}
		
		return result;
	}
}
