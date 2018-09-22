package fr.dawan.reseauSoc.people;

import java.util.Date;

import javax.persistence.EntityManager;

import fr.dawan.reseauSoc.beans.PeopleContent;

public class PeopleContentCtrl {

	private PeopleContent people= new PeopleContent();
	private String msg;
	private String msgPeople;
	private String msgLastName;
	private String msgFirstName;
	private String msgBiography;
	private String msgPicture;
	private String msgBirthDay;
	private boolean error= false;

	public PeopleContentCtrl(String firstName, String lastName, String picture, String biography, int birthday, EntityManager em) {
		peopleExist(firstName, lastName, em);
		ctrlFirstName(firstName);
		ctrlLastName(lastName);
		ctrlBiography(biography);
		ctrlPicture(picture);
		ctrlBirtday(birthday);
	}
	

	@SuppressWarnings("deprecation")
	private void ctrlBirtday(int birthday) {
		Date now= new Date();
		if (birthday > now.getYear() && birthday < 1850) {
			msgBirthDay= "Le date de naissance n'est pas cohérente";
			error= true;
		}
		people.setBirthDay(birthday);
		
	}


	public void ctrlLastName(String lastName) {
		if (lastName.length() < 3) {
			msgLastName= "le nom doit comporter plus de 2 caractères";
			error= true;
		}
		people.setLastName(lastName);
	}
	public void ctrlFirstName(String firstName) {
		if(firstName.length() < 3) {
			msgFirstName= "le prénom doit comporter plus de 2 caractères";
			error= true;
		}
		people.setFirstName(firstName);
	}
	public void ctrlBiography(String biography) {
		if(!biography.isEmpty()) {
			if(biography.length() < 30) {
				System.out.println("chaine trop courte");
				msgBiography= "La biographie doit faire plus de 30 caractéres";
				error= true;	
			} else if (biography.length() > 800) {
				people.setBiography(biography.substring(0, 800));
			} else {
				people.setBiography(biography);
			}
		}
	}
	private void ctrlPicture(String picture) {
		people.setPicture(picture);
	}
	
	public void peopleExist(String firstName, String lastName, EntityManager em) {
		PeopleContent exist= PeopleContentBo.findByName(firstName, lastName, em);
		if (exist != null) {
			msg= "La personnalité existe déja!";
			error= true;
		}
	}

	/* ****************************************************************************************
	 * ***************************GETTERS******************************************************
	 * ***************************************************************************************/
	public String getMsgLastName() {
		return msgLastName;
	}
	public String getMsgFirstName() {
		return msgFirstName;
	}
	public String getMsgBiography() {
		return msgBiography;
	}
	public String getMsg() {
		return msg;
	}
	public String getMsgPicture() {
		return msgPicture;
	}

	public boolean isError() {
		return error;
	}
	public String getMsgPeople() {
		return msgPeople;
	}
	public PeopleContent getPeople() {
		return people;
	}
	public String getMsgBirthDay() {
		return msgBirthDay;
	}	
}
