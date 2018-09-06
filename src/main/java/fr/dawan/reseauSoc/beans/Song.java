package fr.dawan.reseauSoc.beans;

public class Song extends GroupMusic {
	
	private int number;
	private int duration;
	
	/*
	 * *********CONSTRUCTORS
	 */	
	
	public Song() {
		
	}
	
	public Song(int number, int duration) {
		super();
		this.number = number;
		this.duration = duration;
	}

	/*
	 * *********GETTERS/SETTERS
	 */
		
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	
	
	
}
