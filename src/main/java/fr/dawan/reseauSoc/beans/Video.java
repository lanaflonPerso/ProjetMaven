package fr.dawan.reseauSoc.beans;

import java.util.List;

public class Video {

	private List<PeopleContent> actors;
	private List<PeopleContent> realisator;
	private String language;
	
	/*
	 * *********GETTERS/SETTERS
	 */
	public List<PeopleContent> getActors() {
		return actors;
	}
	public void setActors(List<PeopleContent> actors) {
		this.actors = actors;
	}
	public List<PeopleContent> getRealisator() {
		return realisator;
	}
	public void setRealisator(List<PeopleContent> realisator) {
		this.realisator = realisator;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
