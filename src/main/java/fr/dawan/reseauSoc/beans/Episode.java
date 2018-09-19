package fr.dawan.reseauSoc.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "Episode")
public class Episode extends Likable {
		
//	@ManyToOne
//	private Serie serie;
	private int season;
	private int number;
	private String title;
	
	/* ****************************************************************************************
	 * ***************************CONSTRUCTORs*************************************************
	 * ***************************************************************************************/
	public Episode() {
		super();
	}
	
	public Episode(String title, int season, int number) {
		super();
		this.season = season;
		this.number = number;
		this.title = title;
	}

	/* ****************************************************************************************
	 * ***************************GETTERS / SETTERS********************************************
	 * ***************************************************************************************/
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	public Serie getSerie() {
//		return serie;
//	}
//	public void setSerie(Serie serie) {
//		this.serie = serie;
//	}
}
