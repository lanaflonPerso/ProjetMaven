package fr.dawan.reseauSoc.like;

import org.hibernate.Query;
import org.hibernate.Transaction;

import fr.dawan.reseauSoc.beans.Like;
import fr.dawan.reseauSoc.dao.Dao;

public class LikeBo extends Dao {
	
	public static int like(int id, String hql ) {	
		Transaction tx = session().beginTransaction();
		
		int query = session().createQuery(hql)
			.setInteger("id", id)
			.executeUpdate();
		tx.commit();
		
		return query;
	}
		
	/**
	 * permet de savoir si l'objet a déja etait liker!
	 * @param id id de l'objet liker
	 * @param userId id l'utilisateur courant
	 * @return un object Like
	 */
	public static Like myLike(int id, int userId) {
		Like like= null;
		String hql = "FROM Like L WHERE L.likable.id = :id AND L.user.id= :userid";
		Query  query = session().createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("userid", userId);
		
		if(query.list().size() > 0) {
			like= (Like) query.list().get(0);
		}
		return like;
	}
	
	public static int update(Like like) {
		Transaction tx = session().beginTransaction();
		
		String hql = "UPDATE Like L SET L.typeVote= :vote WHERE L.id= :id";
		int query = session().createQuery(hql)
			.setInteger("vote", like.getTypeVote())
			.setInteger("id", like.getId())
			.executeUpdate();
		tx.commit();
		
		return query;
	}
	
	public static Like findByType(String type, int likable) {
		Like like= null;
		String hql = "FROM Like L WHERE L.likable.id = :id AND L.type= :type";
		Query  query = session().createQuery(hql);
		query.setParameter("id", likable);
		query.setParameter("type", type);
		
		if(query.list().size() > 0) {
			like= (Like) query.list().get(0);
		}
		return like;
	}
	
	
	public static void save(Like like) {
		Like isLike= myLike(like.getLikable().getId(), like.getUser().getId());
		
		if(isLike != null) {
			if(like.getTypeVote() != isLike.getTypeVote()) {
				if(like.getTypeVote() == 1) {
					LikeBo.like(like.getLikable().getId(), "UPDATE Likable L SET L.likeCount= L.likeCount+1, L.dislikeCount= L.dislikeCount-1  WHERE L.id= :id");
				} else if(like.getTypeVote() == -1) {
					LikeBo.like(like.getLikable().getId(), "UPDATE Likable L SET L.likeCount= L.likeCount-1, L.dislikeCount= L.dislikeCount+1  WHERE L.id= :id");

				}
				like.setId(isLike.getId());
				update(like);
			}
		}else {
			Dao.save(like);
			if(like.getTypeVote() == 1) {
				LikeBo.like(like.getLikable().getId(), "UPDATE Likable L SET L.likeCount= L.likeCount+1 WHERE L.id= :id");
			} else if(like.getTypeVote() == -1) {
				LikeBo.like(like.getLikable().getId(), "UPDATE Likable L SET L.dislikeCount= L.dislikeCount-1  WHERE L.id= :id");
			}
		}
	}
}
