package fr.dawan.reseauSoc.beans;
import java.util.List;

/**
 * The Class VideoGame.
 */
public class VideoGame extends CulturalContent{
	
	/** plateforme sur lesquels le jeux est disponible ( pc , xbon, ps4 ...). */
	private List<String> platform;
	
	/**nombre de joueur */
	private int numPlayer;

	
	/*
	 * *********CONSTRUCTORS
	 */	
	
	/**
	 * Instantiates a new video game.
	 */
	public VideoGame() {
		
	}
	
	/**
	 * Instantiates a new video game.
	 *
	 * @param platform the platform
	 * @param numPlayer nombre de joueurs
	 */
	public VideoGame(List<String> platform, int numPlayer) {
		super();
		this.platform = platform;
		this.numPlayer = numPlayer;
	}

	
	/*
	 * *********GETTERS/SETTERS
	 */
	

	/**
	 * Gets the platform.
	 *
	 * @return the platform
	 */
	public List<String> getPlatform() {
		return platform;
	}


	/**
	 * Sets the platform.
	 *
	 * @param platform the new platform
	 */
	public void setPlatform(List<String> platform) {
		this.platform = platform;
	}


	/**
	 * Gets the num player.
	 *
	 * @return the num player
	 */
	public int getNumPlayer() {
		return numPlayer;
	}


	/**
	 * Sets the num player.
	 *
	 * @param numPlayer the new num player
	 */
	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}	
	
}
