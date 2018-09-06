package fr.dawan.reseauSoc.beans;

import java.util.List;

public class Album extends GroupMusic {
	
	private GroupMusic artist;
	private List<Song> songs;
	
	/*
	 * *********CONSTRUCTORS
	 */	
	public Album() {
		
	}
	
	public Album(GroupMusic artist, List<Song> songs) {
		super();
		this.artist = artist;
		this.songs = songs;
	}

	/*
	 * *********GETTERS/SETTERS
	 */

	public GroupMusic getArtist() {
		return artist;
	}



	public void setArtist(GroupMusic artist) {
		this.artist = artist;
	}



	public List<Song> getSongs() {
		return songs;
	}



	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	

}
