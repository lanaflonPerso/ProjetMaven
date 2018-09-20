package fr.dawan.reseauSoc.mur;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.dawan.reseauSoc.beans.Category;
import fr.dawan.reseauSoc.beans.Likable;
import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.beans.Mur;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;
import fr.dawan.reseauSoc.like.LikeBo;

public class MurBo extends Dao {

	private Mur mur= new Mur();
	private final String URL= "http://localhost:8080/ReseauSocial/";
	
	public void saveOrUpdate(Mur item, EntityManager em) {
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
	}

//	public static void findByFollower(User user) {
//		String hql = "FROM Mur M WHERE M.followers.id= :id";
//		Query  query = session().createQuery(hql);
//		query.setParameter("id", user.getId());
//		List<Mur> followers= query.list();
//		
//		for (Mur f: followers) {
//			System.out.println(f.toString());
//		}
//		
////		return murs;
//	}
	
	private <T extends Likable> void findUserLike(T item, User user, EntityManager em) {
		mur.setFollowers(LikeBo.findByType(item.getId(), em));
		mur.setFollowers(LikeBo.findByType(user.getId(), em));
		mur.setUser(user);
		mur.setShare(true);
		mur.setLikable(item);
	}
	
	private StringBuilder userString(User user) {
		StringBuilder html = new StringBuilder("");
		html.append("<p>");
		html.append("<a href='"+URL+"user?id="+user.getId()+"'>"+user.getFirstName()+" "+user.getLastName()+"</a> ");
		
		return html;
	}
	
	/**
	 * Enregistre sur le mur un film 
	 * @param movie
	 * @param user
	 * @param em
	 */
	public void setMovie(Movie movie, User user, EntityManager em) {
		findUserLike(movie, user, em);
		for (Category category: movie.getCategorys()) {
			mur.setFollowers(LikeBo.findByType(category.getId(), em));
		}
		
		StringBuilder html= userString(user);
		html.append(" aime le film <a href='"+URL+"movie?id="+movie.getId()+"'>"+movie.getTitle()+" "+movie.getReleaseDate()+"</a>");
		html.append("<p>");
		mur.setHtml(html.toString());
		saveOrUpdate(mur, em);
	}
}