package fr.dawan.reseauSoc.beans;

import java.util.List;

public class GroupMusic extends CulturalContent {

	private List<PeopleContent> members;

	
	/*
	 * *********CONSTRUCTORS
	 */	
	
	public GroupMusic() {
	}

	public GroupMusic(List<PeopleContent> members) {
		super();
		this.members = members;
	}

	/*
	 * *********GETTERS/SETTERS
	 */
	
	
	public List<PeopleContent> getMembers() {
		return members;
	}
	
	
	public void setMembers(List<PeopleContent> members) {
		this.members = members;
	}
	
	
	
}
