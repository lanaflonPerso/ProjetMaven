package fr.dawan.reseauSoc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity  
@Table(name = "likable")  
@Inheritance(strategy=InheritanceType.JOINED) 
public class Likable {

	   @Id  
	   @GeneratedValue(strategy=GenerationType.AUTO)     
	   @Column(name = "id")  
	   private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
