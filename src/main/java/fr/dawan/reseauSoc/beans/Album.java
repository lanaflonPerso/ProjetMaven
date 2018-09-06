package fr.dawan.reseauSoc.beans;

import java.util.List;

/**
 * The Class Album.
 */
public class Album extends GroupMusic {
	
	/** The artist. */
	private GroupMusic artist;
	
	/** The songs. */
	private List<Song> songs;
	
	/**
	 * Instantiates a new album.
	 */
	/*
	 * *********CONSTRUCTORS
	 */	
	public Album() {
		
	}
	
	/**
	 * Instantiates a new album.
	 *
	 * @param artist the artist
	 * @param songs the songs
	 */
	public Album(GroupMusic artist, List<Song> songs) {
		super();
		this.artist = artist;
		this.songs = songs;
	}

	/*
	 * *********GETTERS/SETTERS
	 */

	/**
	 * Gets the artist.
	 *
	 * @return the artist
	 */
	public GroupMusic getArtist() {
		return artist;
	}



	/**
	 * Sets the artist.
	 *
	 * @param artist the new artist
	 */
	public void setArtist(GroupMusic artist) {
		this.artist = artist;
	}



	/**
	 * Gets the songs.
	 *
	 * @return the songs
	 */
	public List<Song> getSongs() {
		return songs;
	}



	/**
	 * Sets the songs.
	 *
	 * @param songs the new songs
	 */
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	

}
