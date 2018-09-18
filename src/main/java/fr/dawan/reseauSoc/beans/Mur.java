package fr.dawan.reseauSoc.beans;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "Mur")
public class Mur {
	
	@Id
	@GeneratedValue
	@Column(name="mur_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="likable_id", nullable=false)
	private Likable likable;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
		name= "Mur_Follower",
		joinColumns = { @JoinColumn(name = "mur_id") },
		inverseJoinColumns = { @JoinColumn(name = "follower_id") }
	)
	private Set<User> followers;
	private boolean share;
	
	@Column(name="mur_dateTime", columnDefinition="DATETIME")
	@Temporal(TemporalType.DATE)
	private Calendar dateTime;
	
	private String html;
	
	
	/* ****************************************************************************************
	 * ****************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public Mur() {
		followers= new HashSet<>();
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS PERSONEL**********************************
	 * ***************************************************************************************/
	public void setFollower(User follower) {
		this.followers.add(follower);
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Likable getLikable() {
		return likable;
	}
	public void setLikable(Likable likable) {
		this.likable = likable;
	}
	public Set<User> getFollowers() {
		return followers;
	}
	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}
	public boolean isShare() {
		return share;
	}
	public void setShare(boolean share) {
		this.share = share;
	}
	public Calendar getDateTime() {
		return dateTime;
	}
	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
}