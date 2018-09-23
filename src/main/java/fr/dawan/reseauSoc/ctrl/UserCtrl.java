package fr.dawan.reseauSoc.ctrl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.user.UserDao;

public class UserCtrl {

	private User user;
	private String msgUser;
	private String msgFirstName;
	private String msgLastName;
	private String msgEmail;
	private String msgPassword;
	private String msgCity;
	private boolean error= false;
	
	public UserCtrl(User user, String pass1, String pass2) {
		this.user= user;
		setFirstName();
		setLastName();	
		setEmail();
		setPasswordEquals(pass1, pass2);
		setPasswordLenfth(pass1);
		if (!error) {
			userExist();
		}
	}

	public void userExist() {
		User userExist= UserDao.findByEmail(user.getEmail());
		if (userExist != null) {
			msgUser= "l'adresse email est déja utilisée";
			error= true;
		}
	}

	public void setPasswordLenfth(String pass1) {
		if(pass1.length() < 7) {
			msgPassword= "le mot de passe doit comporter 8 caractères minimum";
			error= true;
		}
	}
	
	public void setPasswordEquals(String pass1, String pass2) {
		if (!pass1.equals(pass2)) {
			msgPassword= "Les mots de passe ne sont pas identique";
			error= true;
		}
	}
	
	public void setFirstName() {
		if(user.getFirstName().length() < 4) {
			msgFirstName= "le prénom doit comporter plus de 3 caractères";
			error= true;
		}
	}
	public void setLastName() {
		if (user.getLastName().length() < 4) {
			msgLastName= "le nom doit comporter plus de 3 caractères";
			error= true;
		}
	}
	public void setEmail() {
		Pattern p= Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(user.getEmail());
		if(!matcher.find()) {
			msgEmail= "l'adresse mail n'est pas valide!";
			error= true;
		}
		
	}
	
	public String getMsgFirstName() {
		return msgFirstName;
	}
	public String getMsgLastName() {
		return msgLastName;
	}
	public String getMsgEmail() {
		return msgEmail;
	}
	public String getMsgPassword() {
		return msgPassword;
	}
	public String getMsgCity() {
		return msgCity;
	}
	public void setMsgCity(String msgCity) {
		this.msgCity = msgCity;
	}
	public boolean isError() {
		return error;
	}
	public String getMsgUser() {
		return msgUser;
	}
}
