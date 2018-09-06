package fr.dawan.reseauSoc.beans;

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
