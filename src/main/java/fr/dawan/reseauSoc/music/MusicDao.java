package fr.dawan.reseauSoc.music;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.reseauSoc.beans.GroupMusic;
import fr.dawan.reseauSoc.dao.Dao;

public class MusicDao extends Dao {

	public static GroupMusic findByBand(String bandName) {
		GroupMusic group= null;
		
		EntityManager em= Dao.createEntityManager("JPA");
		
		Query query = em.createQuery("SELECT G FROM GroupMusic G WHERE G.bandName = :bandName", GroupMusic.class) ;
		query.setParameter("bandName", bandName);
		if(query.getResultList().size() > 0) {
			group= (GroupMusic) query.getResultList().get(0);
		}
		Dao.close(em);
		return group;	
	}
}
