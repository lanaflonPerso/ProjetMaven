package fr.dawan.reseauSoc.model;

import fr.dawan.reseauSoc.Enum.ContentsEnum;
import fr.dawan.reseauSoc.beans.Album;
import fr.dawan.reseauSoc.beans.Content;
import fr.dawan.reseauSoc.beans.GroupMusic;
import fr.dawan.reseauSoc.beans.PeopleContent;
import fr.dawan.reseauSoc.beans.Song;
import fr.dawan.reseauSoc.beans.VideoGame;

public class ContentFactory {
	
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
