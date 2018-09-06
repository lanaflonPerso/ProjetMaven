package fr.dawan.reseauSoc.beans;

import java.time.LocalDate;
import java.util.List;

import fr.dawan.reseauSoc.Enum.Fonction;
import fr.dawan.reseauSoc.model.Content;

/**
 * The Class PeopleContent.
 */
public class PeopleContent extends Content {

	/** The first name. */
	private String firstName;
	
	/** The nick name. */
	private String nickName;
	
	/** The birth day. */
	private LocalDate birthDay;
	
	/** liste de fonction (enum) pour préciser les "rôle" d'une personne, exemple chanter, réalisateur*/
	private List<Fonction> fonctions;
	
	/*
	 * *********CONSTRUCTORS
	 */	
	
	/**
	 * Instantiates a new people content.
	 */
	public PeopleContent() {
		
	}
	
	/**
	 * Instantiates a new people content.
	 *
	 * @param firstName the first name
	 * @param nickName the nick name
	 * @param birthDay the birth day
	 * @param fonctions the fonctions
	 */
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

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * Gets the nick name.
	 *
	 * @return the nick name
	 */
	public String getNickName() {
		return nickName;
	}


	/**
	 * Sets the nick name.
	 *
	 * @param nickName the new nick name
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	/**
	 * Gets the birth day.
	 *
	 * @return the birth day
	 */
	public LocalDate getBirthDay() {
		return birthDay;
	}


	/**
	 * Sets the birth day.
	 *
	 * @param birthDay the new birth day
	 */
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}


	/**
	 * Gets the fonctions.
	 *
	 * @return the fonctions
	 * @see 
	 */
	public List<Fonction> getFonctions() {
		return fonctions;
	}


	/**
	 * Sets the fonctions.
	 *
	 * @param fonctions the new fonction
	 */
	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}
	
	
	
	
	
}
