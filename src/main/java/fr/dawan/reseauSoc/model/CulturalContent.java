package fr.dawan.reseauSoc.model;

import java.time.LocalDate;

import fr.dawan.reseauSoc.beans.Category;

public abstract class CulturalContent extends Content {
	
	private LocalDate releaseDate;
	private Category category;
	private String studio;
	
	/*
	 * *********GETTERS/SETTERS
	 */
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
}
