package fr.dawan.reseauSoc.comment;

import java.util.Date;

import fr.dawan.reseauSoc.beans.Comment;
import fr.dawan.reseauSoc.beans.Mur;
import fr.dawan.reseauSoc.beans.User;

public class CommentCtrl {
	
	private Comment comment= new Comment();
	private String msgContenu;
	private boolean error= false;
	
	public CommentCtrl(String contenu,User user, Mur wall) {
		comment.setWall(wall);
		comment.setUser(user);
		comment.setCreated_Date(new Date());
		ctrlContenu(contenu);
	}

	private void ctrlContenu(String contenu) {
		if(contenu.length() < 3) {
			msgContenu= "Le commentaire doit contenir plus de 2 caractéres";
			error= true;
		}else if (contenu.length() > 500) {
			comment.setContenu(contenu.substring(0, 500));
		} else {
			comment.setContenu(contenu);
		}
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public Comment getComment() {
		return comment;
	}
	public String getMsgContenu() {
		return msgContenu;
	}
	public boolean isError() {
		return error;
	}	
}
