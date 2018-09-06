package fr.dawan.reseauSoc.beans;

import java.time.LocalDate;
import java.util.List;

import fr.dawan.reseauSoc.model.CulturalContent;

/**
 * The Class GroupMusic.
 */
public class GroupMusic extends CulturalContent {

	/** liste de membre du groupe, une chanteuse par exemple est considere comme un groupe d'une personne. */
	private List<PeopleContent> members;

	
	/*
	 * *********CONSTRUCTORS
	 */	
	
	/**
	 * Instantiates a new group music.
	 */
	public GroupMusic() {
	}
	
	public GroupMusic(Integer id, String name, LocalDate releaseDate, Category category, String studio,
			List<PeopleContent> members) {
		super(id, name, releaseDate, category, studio);
		this.members = members;
	}

	/**
	 * Instantiates a new group music.
	 *
	 * @param members the members
	 */
	public GroupMusic(List<PeopleContent> members) {
		super();
		this.members = members;
	}

	/*
	 * *********GETTERS/SETTERS
	 */
	
	
	/**
	 * Gets the members.
	 *
	 * @return the members
	 */
	public List<PeopleContent> getMembers() {
		return members;
	}
	
	
	/**
	 * Sets the members.
	 *
	 * @param members the new members
	 */
	public void setMembers(List<PeopleContent> members) {
		this.members = members;
	}
	
	
	
}
