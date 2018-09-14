package fr.dawan.reseauSoc.ctrl;

import java.time.LocalDate;

import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.bo.MovieBo;

public class MovieCtrl {

	private Movie movie;
	private String msgMovie;
	private String msgTitle;
	private String msgReleaseDate;
	private String msgPicture;
	private String msgSynopsis;
	private boolean error= false;
	
	public MovieCtrl(Movie movie) {
		this.movie= movie;
		setTitle();
		setReleaseDate();
		if(!error) {
			movieExist();
		}
	}
	
	public void movieExist() {
		Movie exist= MovieBo.findByTitleReleaseDate(movie.getTitle(), movie.getReleaseDate());
		if (exist != null) {
			msgMovie= "le film est déja en base";
			error= true;
		}
	}
	
	public void setTitle() {
		if(movie.getTitle().length() < 5) {
			msgTitle= "Le titre doit avoir plus de 5 caractéres";
			error= true;
		}
	}
	public void setReleaseDate() {
		LocalDate now= LocalDate.now();
		if(movie.getReleaseDate() > now.getYear() || movie.getReleaseDate() < 1900) {
			msgReleaseDate= "Erreur sur la l'année de sortie";
			error= true;
		}
	}
	public void setPicture(String msgPicture) {
		this.msgPicture = msgPicture;
	}
	
	public String getMsgTitle() {
		return msgTitle;
	}
	public String getMsgReleaseDate() {
		return msgReleaseDate;
	}
	public String getMsgPicture() {
		return msgPicture;
	}
	public String getMsgSynopsis() {
		return msgSynopsis;
	}
	public boolean isError() {
		return error;
	}
	public String getMsgMovie() {
		return msgMovie;
	}

	@Override
	public String toString() {
		return "MovieCtrl [movie=" + movie + ", msgMovie=" + msgMovie + ", msgTitle=" + msgTitle + ", msgReleaseDate="
				+ msgReleaseDate + ", msgPicture=" + msgPicture + ", msgSynopsis=" + msgSynopsis + ", error=" + error
				+ "]";
	}
}
