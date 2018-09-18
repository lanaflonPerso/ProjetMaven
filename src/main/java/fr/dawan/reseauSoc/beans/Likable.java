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
@Table(name = "Likable")  
@Inheritance(strategy=InheritanceType.JOINED) 
public class Likable {

	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)     
	@Column(name = "id")  
	private Integer id;
	private int likeCount;
	private int dislikeCount;
	
	public Likable() {
		super();
	}

	public Likable(int id) {
		super();
		this.id = id;
	}

	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getDislikeCount() {
		return dislikeCount;
	}
	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	@Override
	public String toString() {
		return "Likable [id=" + id + ", likeCount=" + likeCount + ", dislikeCount=" + dislikeCount + "]";
	}
	
	
}
