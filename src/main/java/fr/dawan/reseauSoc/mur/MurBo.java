package fr.dawan.reseauSoc.mur;

import fr.dawan.reseauSoc.beans.Category;
import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.beans.Mur;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;
import fr.dawan.reseauSoc.like.LikeBo;

public class MurBo extends Dao {

	private Mur mur= new Mur();
	private final String URL= "http://localhost:8080/ReseauSocial/";
	
	public void setMovie(Movie movie, User user) {
		mur.setFollower((LikeBo.findByType("movie", movie.getId()).getUser()));
		mur.setFollower((LikeBo.findByType("movie", user.getId()).getUser()));
		
		for (Category category: movie.getCategorys()) {
			mur.setFollower((LikeBo.findByType(Integer.toString(category.getId()), movie.getId()).getUser()));
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