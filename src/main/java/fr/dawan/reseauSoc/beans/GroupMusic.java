package fr.dawan.reseauSoc.beans;

import java.util.List;

import fr.dawan.reseauSoc.model.CulturalContent;

public class GroupMusic extends CulturalContent {


	private List<PeopleContent> members;

	/* ****************************************************************************************
	 * ***************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public GroupMusic() {
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public List<PeopleContent> getMembers() {
		return members;
	}
	public void setMembers(List<PeopleContent> members) {
		this.members = members;
	}
}
