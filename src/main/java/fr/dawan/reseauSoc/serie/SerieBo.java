package fr.dawan.reseauSoc.serie;

import javax.persistence.EntityManager;

import fr.dawan.reseauSoc.beans.Serie;
import fr.dawan.reseauSoc.dao.Dao;

public class SerieBo {
	
	public static Serie findById(int id, EntityManager em) {
		Dao dao= new Dao();
		return dao.findById(Serie.class, id, em, false);	
	}
}