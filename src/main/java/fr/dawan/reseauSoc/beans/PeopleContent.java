package fr.dawan.reseauSoc.beans;

import java.time.LocalDate;
import java.util.List;

import fr.dawan.reseauSoc.Enum.Fonction;

public class PeopleContent extends Content {

	private String firstName;
	private String nickName;
	private LocalDate birthDay;
	private List<Fonction> fonctions;
	
	/*
	 * *********CONSTRUCTORS
	 */	
	
	public PeopleContent() {
		
	}
	
	public PeopleContent(String firstName, String nickName, LocalDate birthDay, List<Fonction> fonctions) {
		super();
		this.firstName = firstName;
		this.nickName = nickName;
		this.birthDay = birthDay;
		this.fonctions = fonctions;
	}

	/*
	 * *********GETTERS/SETTERS
	 */

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public LocalDate getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}


	public List<Fonction> getFonctions() {
		return fonctions;
	}


	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}
	
	
	
	
	
}
