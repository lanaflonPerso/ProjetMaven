package fr.dawan.reseauSoc.beans;
import java.util.List;

public class VideoGame extends CulturalContent{
	
	private List<String> platform;
	private int numPlayer;

	
	/*
	 * *********CONSTRUCTORS
	 */	
	
	public VideoGame() {
		
	}
	
	public VideoGame(List<String> platform, int numPlayer) {
		super();
		this.platform = platform;
		this.numPlayer = numPlayer;
	}

	
	/*
	 * *********GETTERS/SETTERS
	 */
	

	public List<String> getPlatform() {
		return platform;
	}


	public void setPlatform(List<String> platform) {
		this.platform = platform;
	}


	public int getNumPlayer() {
		return numPlayer;
	}


	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}	
	
}
