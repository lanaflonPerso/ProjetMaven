package fr.dawan.reseauSoc.ctrl;

import javax.persistence.EntityManager;

import fr.dawan.reseauSoc.beans.Mur;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.mur.MurBo;

public class ShortContentCtrl {

	private Mur wall= new Mur();
	private String msgShortContent;
	private boolean error= false;
	private String shortContent;
	
	
	public ShortContentCtrl(String message, User user, EntityManager em) {
		setShortContent(message);
		shortContent= message;
		wall.setUser(user);
		wall.setLikable(user);
		wall.setShare(true);
		
		if(!error) {
			MurBo.setShorContent(wall, em);
		}
		
	}
	
	public void setShortContent(String message) {
		if(message.length() < 15) {
			msgShortContent= "Le message doit contenir plus de 15 caractéres";
			error= true;
		}else if (message.length() > 493) {
			wall.setHtml("<p>"+message.substring(0, 493)+"</p>");
		} else {
			wall.setHtml("<p>"+message+"<p>");
		}
	}
	public Mur getMur() {
		return wall;
	}

	public String getMsgShortContent() {
		return msgShortContent;
	}

	public boolean isError() {
		return error;
	}
	public String getShortContent() {
		return shortContent;
	}
}
