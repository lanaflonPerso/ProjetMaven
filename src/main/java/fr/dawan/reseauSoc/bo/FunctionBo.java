package fr.dawan.reseauSoc.bo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import fr.dawan.reseauSoc.beans.Function;

public class FunctionBo {
	
	public static Function isExist(String name, Session session) {
		Function result;
		
		Criteria criteria = session.createCriteria(Function.class);
		Criterion critere = Restrictions.eq("function", name);
		criteria.add(critere);
	
		if(criteria.list().size() > 0) {
			result= (Function) criteria.list().get(0);
		} else {
			result= new Function();
			result.setFunction(name);
			Transaction tx = session.beginTransaction();
			result.setId((Integer) session.save(result));
			System.out.println("Nouvelle fonction enregistrer: "+ name +"!!");
			tx.commit();	
		}
		
		return result;
	}
}
