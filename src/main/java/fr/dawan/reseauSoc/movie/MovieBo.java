package fr.dawan.reseauSoc.movie;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.dao.Dao;

public class MovieBo extends Dao {
	
	/**
	 * Recherche un film par son Id
	 * @param id
	 * @param session
	 * @return un film
	 */
	@SuppressWarnings("unchecked")
	public static Movie findById(int id) {
		Session session= session();
		Movie movie= null;
		Criteria criteria = session.createCriteria(Movie.class);
		Criterion critere = Restrictions.eq("id", id);
		criteria.add(critere);
		List<Movie> movies = (List<Movie>) criteria.list();
		
		if(movies.size() > 0) {
			movie= movies.get(0);
		}
		return movie;	
	}
	
	public static Movie findByTitleReleaseDate(String title, int releaseDate) {
		Session session= session();
		Movie movie= null;
		
		Criteria criteria = session.createCriteria(Movie.class);
		Criterion critere = Restrictions.eq("title", title);
		Criterion critere2 = Restrictions.eq("releaseDate", releaseDate);
		
		criteria.add(critere);
		criteria.add(critere2);
		
		if(criteria.list().size() > 0) {
			movie= (Movie) criteria.list().get(0);	
		}
		
		return movie;	
	}
	
	@SuppressWarnings("unchecked")
	public static List<Movie> findByTitle(Session session, String title) {
		Criteria criteria = session.createCriteria(Movie.class);
		Criterion critere = Restrictions.like("title", title, MatchMode.ANYWHERE);
		
		criteria.add(critere);
		List<Movie> movies = (List<Movie>) criteria.list();
		return movies;
	}
}