package fr.dawan.reseauSoc.ctrl;

import java.time.LocalDate;

public class Ctrl {
	
	protected String msgReleaseDate;
	protected boolean error= false;

	protected int ctrlDate(String releaseDate) {
		LocalDate now= LocalDate.now();
		int date=0;
		try {
			date= Integer.valueOf(releaseDate);
		} catch (Exception e) {
			msgReleaseDate= "Erreur sur la l'année de sortie";
			error= true;
		}
		if(date > now.getYear() || date < 1900) {
			msgReleaseDate= "Erreur sur la l'année de sortie";
			error= true;
		}
		return date;
	}

	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public boolean isError() {
		return error;
	}
	public String getMsgReleaseDate() {
		return msgReleaseDate;
	}
}
