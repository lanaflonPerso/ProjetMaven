package fr.dawan.reseauSoc.Util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.dawan.reseauSoc.beans.Song;

public final class ConvertJson {

	private ObjectMapper mapper = new ObjectMapper();
	private static ConvertJson instance = null;

	private ConvertJson() {
	}

	public final static ConvertJson getInstance() {
		if (ConvertJson.instance.equals(null)) {
			ConvertJson.instance = new ConvertJson();
		}
		return ConvertJson.instance;
	}

	public Song toObject(String jsonString) {
		Song song = null;
		try {
			song = mapper.readValue(jsonString, Song.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return song;
	}

	public String toJson(Song mySong) {
		String str = null;
		try {
			str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mySong);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

}
