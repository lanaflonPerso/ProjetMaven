package fr.dawan.reseauSoc.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * The Class Album.
 */
/**
 * @author Pierre
 *
 */
public class Album extends GroupMusic implements Serializable {
	
	/** Serialisation ID */
	private static final long serialVersionUID = -4710312449379468329L;

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

	public Album(Integer id, String name, LocalDate releaseDate, Category category, String studio,
			List<PeopleContent> members, GroupMusic artist, List<Song> songs) {
		super(id, name, releaseDate, category, studio, members);
		this.artist = artist;
		this.songs = songs;
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
