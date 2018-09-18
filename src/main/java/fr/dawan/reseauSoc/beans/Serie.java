package fr.dawan.reseauSoc.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Serie")
public class Serie implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="serie_id")
	private Integer id;
	private String name;
	private LocalDate releaseDate;
	private String studio;
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(
		name= "Serie_PeopleContent",
		joinColumns = { @JoinColumn(name = "serie_id") },
		inverseJoinColumns = { @JoinColumn(name = "peopleContent_id") }
	)
	private List<PeopleContent> actors= new ArrayList<PeopleContent>();
	
//	private List<PeopleContent> showRunners;
	@OneToMany(mappedBy="serie")
	private List<Episode> Episodes= new ArrayList<>();
	
	/* ****************************************************************************************
	 * ***************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public Serie () {

	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS PERSONEL**********************************
	 * ***************************************************************************************/
	public List<PeopleContent> getActors() {
		return actors;
	}
	
	public void setActor(PeopleContent actor) {
		actors.add(actor);
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public void setActors(List<PeopleContent> actors) {
		this.actors = actors;
	}
	public List<Episode> getEpisodes() {
		return Episodes;
	}
	public void setEpisodes(List<Episode> episodes) {
		Episodes = episodes;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
