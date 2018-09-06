package fr.dawan.reseauSoc.model;

public abstract class Content {
	
	private Integer id;
	private String name;
	
	/*
	 * *********GETTERS/SETTERS
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setNom(String name) {
		this.name = name;
	}
}
