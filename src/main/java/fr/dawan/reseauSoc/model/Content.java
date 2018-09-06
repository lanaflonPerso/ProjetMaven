package fr.dawan.reseauSoc.model;

public abstract class Content {
	
	private Integer id;
	private String nom;
	
	/*
	 * *********GETTERS/SETTERS
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
