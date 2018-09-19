package fr.dawan.reseauSoc.mur;

import java.util.List;

import org.hibernate.Query;

import fr.dawan.reseauSoc.beans.Category;
import fr.dawan.reseauSoc.beans.Like;
import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.beans.Mur;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;
import fr.dawan.reseauSoc.like.LikeBo;

public class MurBo extends Dao {

	private Mur mur= new Mur();
	private final String URL= "http://localhost:8080/ReseauSocial/";
	

	public static void findByFollower(User user) {
		String hql = "FROM Mur M WHERE M.followers.id= :id";
		Query  query = session().createQuery(hql);
		query.setParameter("id", user.getId());
		List<Mur> followers= query.list();
		
		for (Mur f: followers) {
			System.out.println(f.toString());
		}
		
//		return murs;
	}
	
	public void setMovie(Movie movie, User user) {
		Like movie_like= LikeBo.findByType("movie", movie.getId());
		if(movie_like != null) {
			mur.setFollower(movie_like.getUser());
		}
		Like user_like= LikeBo.findByType("movie", user.getId());
		if (user_like != null) {
			mur.setFollower(user_like.getUser());	
		}
		
		for (Category category: movie.getCategorys()) {
			Like category_like= LikeBo.findByType(Integer.toString(category.getId()), movie.getId());
			if(category_like != null) {
				mur.setFollower((category_like.getUser()));	
			}
		}
		mur.setUser(user);
		mur.setShare(true);
		mur.setLikable(movie);
		
		StringBuilder html = new StringBuilder("");
		html.append("<p>");
		html.append("<a href='"+URL+"user?id="+user.getId()+"'>"+user.getFirstName()+" "+user.getLastName()+"</a> ");
		html.append(" aime le film <a href='"+URL+"movie?id="+movie.getId()+"'>"+movie.getTitle()+" "+movie.getReleaseDate()+"</a>");
		mur.setHtml(html.toString());
		Dao.save(mur);
	}
}