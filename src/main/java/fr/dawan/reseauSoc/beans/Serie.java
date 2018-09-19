package fr.dawan.reseauSoc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Serie")
public class Serie extends Video {
	
	private String title;
	private Integer releaseDate;
	private String studio;
	
//	private List<PeopleContent> showRunners;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Episode> Episodes= new ArrayList<>();
	
	/* ****************************************************************************************
	 * ***************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public Serie () {

	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS PERSONEL**********************************
	 * ***************************************************************************************/
	public void setEpisode(Episode episode) {
		Episodes.add(episode);
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
	public List<Episode> getEpisodes() {
		return Episodes;
	}
	public void setEpisodes(List<Episode> episodes) {
		Episodes = episodes;
	}
	public void setReleaseDate(Integer releaseDate) {
		this.releaseDate = releaseDate;
	}
}
