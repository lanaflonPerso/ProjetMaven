package fr.dawan.reseauSoc.like;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.dawan.reseauSoc.beans.LikeDislike;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;

public class LikeBo extends Dao {
	
	/**
	 * Met a jour les LikeCount et DislikeCount
	 * @param id id de l'élément
	 * @param hql requête pour metre a jour le compteur de LikeCount et DislikeCount
	 * @param em L'EntityManager
	 * @return
	 */
	public static int like(int id, String hql, EntityManager em) {	
		em.getTransaction().begin();
		Query query = em.createQuery(hql);
		query.setParameter("id", id);
		int rowsUpdated = query.executeUpdate();
		em.getTransaction().commit();

		return rowsUpdated;
	}
		
	/**
	 * permet de savoir si l'objet a déja etait liker!
	 * @param id id de l'objet liker
	 * @param userId id l'utilisateur courant
	 * @return un object Like
	 */
	public static LikeDislike myLike(int id, int userId, EntityManager em) {
		LikeDislike like= null;

		Query query = em.createQuery("FROM LikeDislike L WHERE L.likable.id = :id AND L.user.id= :userid");
		query.setParameter("id", id);
		query.setParameter("userid", userId);
		
		if(query.getResultList().size() > 0) {
			like= (LikeDislike) query.getResultList().get(0);
		}
		return like;		
	}
	
	
	@SuppressWarnings("unchecked")
	public static Set<User> findByType(int likableId, EntityManager em) {		
		Query query = em.createQuery("SELECT L FROM LikeDislike L WHERE L.likable.id= :id AND L.typeVote= 1", LikeDislike.class) ;
		query.setParameter("id",  likableId);
		
		Set<User> users= new HashSet<>();
		List<LikeDislike> list=  query.getResultList();
		if(query.getResultList().size() > 0) {
			for (LikeDislike like : list) {
				users.add(like.getUser());
			}
		}
		
		return users;
	}
	
	/**
	 * Enregistre ou met a jour le like de l'élément
	 * @param item
	 * @param em
	 */
	private static void saveOrUpdate(LikeDislike item, EntityManager em) {
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
	
	/**
	 * on verifie si l'élément a dèja etait liker on crée un JPQL en fonction et on l'enregistre!
	 * @param like
	 * @param em
	 * @return 
	 */
	public static boolean save(LikeDislike like) {
		EntityManager em= Dao.createEntityManager("JPA");
		boolean result= true;
		//on verifie si on a deja liker le produit!
		LikeDislike isLike= myLike(like.getLikable().getId(), like.getUser().getId(), em);
		
		
		if(isLike != null) {
			if(isLike.getTypeVote() != like.getTypeVote()) {
				if(like.getTypeVote() != isLike.getTypeVote()) {
					if(like.getTypeVote() == 1) {
						LikeBo.like(like.getLikable().getId(), "UPDATE Likable L SET L.likeCount= L.likeCount+1, L.dislikeCount= L.dislikeCount-1  WHERE L.id= :id", em);
					} else if(like.getTypeVote() == -1) {
						LikeBo.like(like.getLikable().getId(), "UPDATE Likable L SET L.likeCount= L.likeCount-1, L.dislikeCount= L.dislikeCount+1  WHERE L.id= :id", em);
	
					}
					like.setId(isLike.getId());
					saveOrUpdate(like, em);
				} else {
					return false;
				}
			}
		} else {
			saveOrUpdate(like, em);
			if(like.getTypeVote() == 1) {
				LikeBo.like(like.getLikable().getId(), "UPDATE Likable L SET L.likeCount= L.likeCount+1 WHERE L.id= :id", em);
			} else if(like.getTypeVote() == -1) {
				LikeBo.like(like.getLikable().getId(), "UPDATE Likable L SET L.dislikeCount= L.dislikeCount-1  WHERE L.id= :id", em);
			} 
		}
		em.close();
		Dao.close();
		return result;
	}
}
