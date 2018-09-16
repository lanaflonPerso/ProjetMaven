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
	@Column(length = 800)
	private String synopsis;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
		name= "Movie_PeopleContent",
		joinColumns = { @JoinColumn(name = "movie_id") },
		inverseJoinColumns = { @JoinColumn(name = "peopleContent_id") }
	)
	private List<PeopleContent> actors;
	@JoinTable(
			name= "Video_Category",
			joinColumns = { @JoinColumn(name = "Video_id") },
			inverseJoinColumns = { @JoinColumn(name = "Category_id") }
		)
	private List<Category> category;
	
	/* ****************************************************************************************
	 * ****************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public Movie() {
		actors= new ArrayList<>();
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS PERSONEL**********************************
	 * ***************************************************************************************/
	public void setActor(PeopleContent actor) {
		actors.add(actor);
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
		this.synopsis = synopsis;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
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
