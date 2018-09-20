package fr.dawan.reseauSoc.people;

import javax.persistence.EntityManager;

import fr.dawan.reseauSoc.beans.PeopleContent;

public class PeopleContentCtrl {

	private PeopleContent people;
	private String msgPeople;
	private String msgLastName;
	private String msgFirstName;
	private String msgBiography;
	private String msgpicture;
	private boolean error= false;

	public PeopleContentCtrl(PeopleContent people) {
		this.people= people;
		setFirstName();
		setLastName();
		setMsgBiography();
	}
	
	public void setLastName() {
		if (people.getLastName().length() < 3) {
			msgLastName= "le nom doit comporter plus de 2 caractères";
			error= true;
		}
	}
	public void setFirstName() {
		if(people.getFirstName().length() < 3) {
			msgFirstName= "le prénom doit comporter plus de 2 caractères";
			error= true;
		}
	}
	public void setMsgBiography() {
		if(!people.getBiography().isEmpty()) {
			if(people.getBiography().length() < 30) {
				System.out.println("chaine trop courte");
				msgBiography= "La biographie doit faire plus de 30 caractéres";
				error= true;	
			}
		}
	}
	
	public void peopleExist(EntityManager em) {
		PeopleContent exist= PeopleContentBo.findByName(people.getFirstName(), people.getLastName(), em);
		if (exist != null) {
			people= exist;
//			msgPeople= "une personalité est déja en base avec le même nom et prénom!";
//			error= true;
		}
	}

	
	public String getMsgLastName() {
		return msgLastName;
	}


	public String getMsgFirstName() {
		return msgFirstName;
	}


	public String getMsgBiography() {
		return msgBiography;
	}


	public String getMsgpicture() {
		return msgpicture;
	}

	public void setMsgpicture(String msgpicture) {
		this.msgpicture = msgpicture;
	}

	public boolean isError() {
		return error;
	}
	public String getMsgPeople() {
		return msgPeople;
	}

	@Override
	public String toString() {
		return "PeopleContentCtrl [people=" + people + ", msgLastName=" + msgLastName + ", msgFirstName=" + msgFirstName
				+ ", msgBiography=" + msgBiography + ", msgpicture=" + msgpicture + ", error=" + error + "]";
	}	
}
