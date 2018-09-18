package fr.dawan.reseauSoc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Movie")
@PrimaryKeyJoinColumn(name="id") 
public class Movie extends Likable {
	
	private String title;
	@Column(length = 4)
	private int releaseDate;
	private String studio;
	private String picture;
	@Column(length = 1500)
	private String synopsis;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
		name= "Movie_PeopleContent",
		joinColumns = { @JoinColumn(name = "movie_id") },
		inverseJoinColumns = { @JoinColumn(name = "peopleContent_id") }
	)
	private List<PeopleContent> actors= new ArrayList<>();
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
		name= "Video_Category",
		joinColumns = { @JoinColumn(name = "video_id") },
		inverseJoinColumns = { @JoinColumn(name = "Category_id") }
	)
	private List<Category> categorys= new ArrayList<>();
	
	/* ****************************************************************************************
	 * ****************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public Movie() {
		
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS PERSONEL**********************************
	 * ***************************************************************************************/
	public void setActor(PeopleContent actor) {
		actors.add(actor);
	}
	
	public void setCategory(Category category) {
		this.categorys.add(category);
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public List<PeopleContent> getActors() {
		return actors;
	}
	public void setActors(List<PeopleContent> actors) {
		this.actors = actors;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		if(synopsis.length() < 1500) {
			this.synopsis = synopsis;
		} else {
			this.synopsis = synopsis.substring(0, 1499);
		}
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	/* ****************************************************************************************
	 * ****************************OVERRIDE****************************************************
	 * ***************************************************************************************/
	@Override
	public String toString() {
		return "Movie [title=" + title + ", releaseDate=" + releaseDate + ", studio=" + studio
				+ ", synopsis="+ synopsis+", actors=" + actors + "]";
	}		
}
