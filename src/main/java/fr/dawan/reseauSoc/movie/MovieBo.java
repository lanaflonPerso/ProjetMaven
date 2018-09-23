package fr.dawan.reseauSoc.movie;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.dao.Dao;

public class MovieBo extends Dao {
		
	public static Movie findByTitleReleaseDate(String title, int releaseDate) {
	
		Movie movie= null;
		
		EntityManager em= Dao.createEntityManager("JPA");
		
		Query query = em.createQuery("SELECT movie FROM Movie movie WHERE movie.title = :title AND movie.releaseDate= :date") ;
		query.setParameter("title",  title);
		query.setParameter("date",  releaseDate);
		if(query.getResultList().size() > 0) {
			movie = (Movie) query.getResultList().get(0);
		}
		Dao.close(em);
		return movie;	
	}
}