package fr.dawan.reseauSoc.serie;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.reseauSoc.beans.Serie;
import fr.dawan.reseauSoc.dao.Dao;

public class SerieBo {
	
	public static Serie findById(int id, EntityManager em) {
		Dao dao= new Dao();
		return dao.findById(Serie.class, id, em);	
	}
	
	@SuppressWarnings("unchecked")
	public static List<Serie> findByTitle(String title, EntityManager em) {	
		Query query = em.createQuery("SELECT serie FROM Serie serie WHERE serie.title LIKE :title") ;
		query.setParameter("title",  "%"+title+"%");
		
		List<Serie> series = query.getResultList();
		
		return series;	
	}
}