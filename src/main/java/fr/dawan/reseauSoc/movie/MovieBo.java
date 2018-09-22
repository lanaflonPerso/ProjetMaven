package fr.dawan.reseauSoc.movie;

import java.util.List;

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
		em.close();
		Dao.close();
		return movie;	
	}
	
	@SuppressWarnings("unchecked")
	public static List<Movie> findByTitle(String title, EntityManager em) {	
		Query query = em.createQuery("SELECT movie FROM Movie movie WHERE movie.title LIKE :title") ;
		query.setParameter("title",  "%"+title+"%");
		
		List<Movie> movies = query.getResultList();
		
		return movies;	
	}
}