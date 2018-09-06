package fr.dawan.reseauSoc.model;

import fr.dawan.reseauSoc.Enum.ContentsEnum;
import fr.dawan.reseauSoc.beans.Album;
import fr.dawan.reseauSoc.beans.GroupMusic;
import fr.dawan.reseauSoc.beans.PeopleContent;
import fr.dawan.reseauSoc.beans.Song;
import fr.dawan.reseauSoc.beans.VideoGame;


/**
 * A factory for creating Content objects.
 */
public class ContentFactory {
	
	
	
	/**
	 * Factory d'objet h�rit�s de content .
	 *
	 * @param type : ContentEnum afin
	 * @return l'objet du type pass� en parametre
	 */
	public Content createContent(ContentsEnum type) {
		switch (type) {
		case Album:
			return new Album();
			
		case GroupMusic:
			return new GroupMusic();
		
		case PeopleContent:
			return new PeopleContent();
			
		case Song: 
			return new Song();
			
		case VideoGame:
			return new VideoGame();
			
		default:
			break;
		}
	}
	
}
