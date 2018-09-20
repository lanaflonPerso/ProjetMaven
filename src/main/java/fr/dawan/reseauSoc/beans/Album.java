package fr.dawan.reseauSoc.beans;

import java.util.List;


public class Album extends GroupMusic {

	private GroupMusic artist;
	private List<Song> songs;	

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
