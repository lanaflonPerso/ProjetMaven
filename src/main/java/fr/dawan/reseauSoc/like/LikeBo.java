package fr.dawan.reseauSoc.like;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.dawan.reseauSoc.beans.LikeDislike;
import fr.dawan.reseauSoc.dao.Dao;

public class LikeBo extends Dao {
	
	@SuppressWarnings("unused")
	public static int like(int id, String hql, EntityManager em) {	
		em.getTransaction().begin();;
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
	@SuppressWarnings("unused")
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
	
	@SuppressWarnings("unused")
	public static int update(LikeDislike like, EntityManager em) {
		em.getTransaction().begin();
		Query query = em.createQuery("UPDATE LikeDislike L SET L.typeVote= :vote WHERE L.id= :id") ;
		query.setParameter("vote", like.getTypeVote());
		query.setParameter("id", like.getId());
		int rowsUpdated = query.executeUpdate();
		em.getTransaction().commit();

		return rowsUpdated;
	}
	
	public static LikeDislike findByType(String type, int likableId, EntityManager em) {
		LikeDislike like= null;
		
		Query query = em.createQuery("SELECT L FROM LikeDislike L WHERE L.likable.id= :id AND L.type= :type") ;
		query.setParameter("id",  likableId);
		query.setParameter("type",  type);
		
		if(query.getResultList().size() > 0) {
			like= (LikeDislike) query.getResultList().get(0);
		}
		
		return like;
	}
	
	public static void saveOrUpdate(LikeDislike item, EntityManager em, boolean closeConnection) {
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
		if (closeConnection) {
			em.close();
		}
	}
	
	public static void save(LikeDislike like, EntityManager em) {
		LikeDislike isLike= myLike(like.getLikable().getId(), like.getUser().getId(), em);
		
		if(isLike != null) {
			if(like.getTypeVote() != isLike.getTypeVote()) {
				if(like.getTypeVote() == 1) {
					LikeBo.like(like.getLikable().getId(), "UPDATE LikeDislike L SET L.likeCount= L.likeCount+1, L.dislikeCount= L.dislikeCount-1  WHERE L.id= :id", em);
				} else if(like.getTypeVote() == -1) {
					LikeBo.like(like.getLikable().getId(), "UPDATE LikeDislike L SET L.likeCount= L.likeCount-1, L.dislikeCount= L.dislikeCount+1  WHERE L.id= :id", em);

				}
				like.setId(isLike.getId());
				update(like, em);
			}
		}else {
			saveOrUpdate(like, em, false);
			if(like.getTypeVote() == 1) {
				LikeBo.like(like.getLikable().getId(), "UPDATE LikeDislike L SET L.likeCount= L.likeCount+1 WHERE L.id= :id", em);
			} else if(like.getTypeVote() == -1) {
				LikeBo.like(like.getLikable().getId(), "UPDATE LikeDislike L SET L.dislikeCount= L.dislikeCount-1  WHERE L.id= :id", em);
			}
		}
	}
}
