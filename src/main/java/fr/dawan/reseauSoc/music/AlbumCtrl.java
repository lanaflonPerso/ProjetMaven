package fr.dawan.reseauSoc.music;

import fr.dawan.reseauSoc.beans.Album;
import fr.dawan.reseauSoc.beans.GroupMusic;
import fr.dawan.reseauSoc.ctrl.Ctrl;

public class AlbumCtrl extends Ctrl {

	private Album album= new Album();
	private String msgTitle;
	private String msgbandName;
	private String msgPicture;
	
	public AlbumCtrl(String title, String releaseDate, String band, String picture) {
		ctrlTitle(title);
		ctrlReleaseDate(releaseDate);
		ctrlBand(band);
		ctrlPicture(picture);
	}
	
	/* ****************************************************************************************
	 * ****************************METHOD CTRL*************************************************
	 * ***************************************************************************************/
	public void ctrlTitle(String title) {
		if(title.length() < 1) {
			msgTitle= "le champ est obligatoire";
			error= true;
		}
		album.setTitle(title);
	}
	
	public void ctrlReleaseDate(String releaseDate) {
		int date= ctrlDate(releaseDate);
		album.setReleaseDate(date);
	}
	
	public void ctrlBand(String bandName) {
		if(bandName.length() < 1) {
			msgbandName= "le champ est obligatoire";
			error= true;
		} else {
			GroupMusic group= MusicDao.findByBand(bandName);
			if (group != null) {
				System.out.println("ùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùù");
				System.out.println("ùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùù");
				System.out.println("ùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùù");
				System.out.println("ùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùù");
				System.out.println("le groupe existe= "+group.getId());
				album.setBand(group);
			} else {
				GroupMusic newGroup= new GroupMusic(bandName);
				album.setBand(newGroup);
			}
		}
	}
	
	public void ctrlPicture(String picture) {
		album.setPicture(picture);
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public String getMsgTitle() {
		return msgTitle;
	}
	public String getMsgReleaseDate() {
		return msgReleaseDate;
	}
	public String getMsgPicture() {
		return msgPicture;
	}
	public Album getAlbum() {
		return album;
	}
	public String getMsgbandName() {
		return msgbandName;
	}
}
