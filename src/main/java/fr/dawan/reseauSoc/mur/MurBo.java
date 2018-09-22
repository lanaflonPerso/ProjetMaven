package fr.dawan.reseauSoc.mur;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.dawan.reseauSoc.beans.Category;
import fr.dawan.reseauSoc.beans.Likable;
import fr.dawan.reseauSoc.beans.LikeDislike;
import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.beans.Mur;
import fr.dawan.reseauSoc.beans.PeopleContent;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;
import fr.dawan.reseauSoc.like.LikeBo;

public class MurBo extends Dao {

	private Mur mur= new Mur();
	private final String URL= "http://localhost:8080/ReseauSocial/";
	
	public static Mur findById(int id, EntityManager em) {
		Mur result= null;
		try {
			result=em.find(Mur.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void saveOrUpdate(Mur item) {
		EntityManager em= Dao.createEntityManager("JPA");
		EntityTransaction tx= em.getTransaction();
		try {
			tx.begin();
			if (item.getId() == null ) {
				em.persist(item);
			} else {
				em.merge(item);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		em.close();
		Dao.close();
	}

	private <T extends Likable> void findUserLike(T item, User user, EntityManager em) {
		mur.setFollowers(LikeBo.findByType(item.getId(), em));
		mur.setFollowers(LikeBo.findByType(user.getId(), em));
		mur.setUser(user);
		mur.setShare(true);
		mur.setLikable(item);
		mur.setCreatedDate(new Date());
	}
	
	/**
	 * Enregistre sur le mur un film 
	 * @param movie
	 * @param user
	 * @param em
	 */
	public void setMovie(Movie movie, User user, LikeDislike like) {
		EntityManager em= Dao.createEntityManager("JPA");
		findUserLike(movie, user, em);
		for (Category category: movie.getCategorys()) {
			mur.setFollowers(LikeBo.findByType(category.getId(), em));
		}
		
		StringBuilder html= new StringBuilder();
		if(like.getTypeVote() == 1) {
			html.append("aime le film <a href='"+URL+"movie?id="+movie.getId()+"'>"+movie.getTitle()+" "+movie.getReleaseDate()+"</a>");
		} else {
			html.append("n'aime pas le film <a href='"+URL+"movie?id="+movie.getId()+"'>"+movie.getTitle()+" "+movie.getReleaseDate()+"</a>");
		}
		mur.setHtml(html.toString());
		saveOrUpdate(mur);
		em.close();
		Dao.close();
	}

	public void setCategory(Category category, User user, LikeDislike like) {
		EntityManager em= Dao.createEntityManager("JPA");
		findUserLike(category, user, em);
		StringBuilder html= new StringBuilder();
		if(like.getTypeVote() == 1) {
			html.append("aime le genre <a href='"+URL+"category?id="+category.getId()+"'>"+category.getName()+"</a>");
		} else {
			html.append("n'aime pas le genre <a href='"+URL+"category?id="+category.getId()+"'>"+category.getName()+"</a>");
		}
		mur.setHtml(html.toString());
		saveOrUpdate(mur);
		
		em.close();
		Dao.close();		
	}
	
	public static void setShorContent(Mur wall, EntityManager em) {
		wall.setFollowers(LikeBo.findByType(wall.getUser().getId(), em));
		saveOrUpdate(wall);
	}
	
	public void setUser(User searchedUser, User user, LikeDislike like) {
		EntityManager em= Dao.createEntityManager("JPA");
		findUserLike(searchedUser, user, em);
		StringBuilder html = new StringBuilder();
		if(like.getTypeVote() == 1) {
			html.append("suit ");
		} else {
			html.append("ne souhaite pas suivre ");
		}
		html.append("<a href='"+URL+"user?id="+searchedUser.getId()+"'>"+searchedUser.getFirstName()+" "+searchedUser.getLastName()+"</a>");
		mur.setHtml(html.toString());
		saveOrUpdate(mur);
		
		em.close();
		Dao.close();
	}
	
	public void setPeopleContent(PeopleContent people, User user, LikeDislike like) {
		EntityManager em= Dao.createEntityManager("JPA");
		findUserLike(people, user, em);
		StringBuilder html = new StringBuilder();
		if(like.getTypeVote() == 1) {
			html.append("aime ");
		} else {
			html.append("n'aime pas ");
		}
		html.append("<a href='"+URL+"people?id="+people.getId()+"'>"+people.getFirstName()+" "+people.getLastName()+"</a>");
		mur.setHtml(html.toString());
		saveOrUpdate(mur);	
	}
}