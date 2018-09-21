package fr.dawan.reseauSoc.comment;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.dawan.reseauSoc.beans.Comment;
import fr.dawan.reseauSoc.dao.Dao;

public class CommentDao extends Dao{

	public static void saveOrUpdate(Comment comment, EntityManager em) {
		EntityTransaction tx= em.getTransaction();
		try {
			tx.begin();
			if (comment.getId() == null ) {
				em.persist(comment);
			} else {
				em.merge(comment);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
