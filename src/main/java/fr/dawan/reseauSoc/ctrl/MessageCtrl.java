package fr.dawan.reseauSoc.ctrl;

import java.util.Date;

import javax.persistence.EntityManager;

import fr.dawan.reseauSoc.beans.Message;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;

public class MessageCtrl {

	private Message message= new Message();
	private String msg;
	private String msgContents;
	private boolean error= false;
	
	public MessageCtrl(User sender, int receiverId, String contents) {
		message.setSender(sender);
		searchReceiver(receiverId);
		ctrlContents(contents);
		message.setCreatedAt(new Date());
		
	}
	
	public void searchReceiver(int receiverId) {
		EntityManager em= Dao.createEntityManager("JPA");
		User receiver= Dao.findById(User.class, receiverId, em);
		Dao.close(em);
		if(receiver == null) {
			msg= "Utilisateur inconnue!";
			error= true;
		} else {
			message.setReceiver(receiver);
		}
	}
	
	public void ctrlContents(String contents) {
		if(contents.length() < 1) {
			msgContents= "Le message est trop court";
			error= true;
		} else if (contents.length() > 500) {
			message.setContents(contents.substring(0, 500));
		}
		message.setContents(contents);
	}

	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsgContents() {
		return msgContents;
	}

	public void setMsgContents(String msgContents) {
		this.msgContents = msgContents;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}	
}
