package fr.dawan.reseauSoc.beans;

import java.util.List;

import fr.dawan.reseauSoc.model.CulturalContent;

/**
 * The Class GroupMusic.
 */
public class GroupMusic extends CulturalContent {

	/** liste de membre du groupe, une chanteuse par exemple est consirdere comme un groupe d'une personne. */
	private List<PeopleContent> members;

	
	/*
	 * *********CONSTRUCTORS
	 */	
	
	/**
	 * Instantiates a new group music.
	 */
	public GroupMusic() {
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
