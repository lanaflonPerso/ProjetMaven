package fr.dawan.reseauSoc.beans;

import java.time.LocalDate;
import java.util.List;

/**
 * The Class Song.
 */


public class Song extends GroupMusic {
	
	/** numero de piste. */
	private int number;
	
	/** durée de la chanson */
	private int duration;
	
	/*
	 * *********CONSTRUCTORS
	 */	
	
	/**
	 * Instantiates a new song.
	 */
	public Song() {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param releaseDate
	 * @param category
	 * @param studio
	 * @param members
	 * @param number
	 * @param duration
	 */
	public Song(Integer id, String name, LocalDate releaseDate, Category category, String studio,
			List<PeopleContent> members, int number, int duration) {
		super(id, name, releaseDate, category, studio, members);
		this.number = number;
		this.duration = duration;
	}

	/**
	 * Instantiates a new song.
	 *
	 * @param number  numero de piste
	 * @param duration the duration
	 */
	public Song(int number, int duration) {
		super();
		this.number = number;
		this.duration = duration;
	}
	
	

	/*
	 * *********GETTERS/SETTERS
	 */
		
	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration the new duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	
	
	
}
