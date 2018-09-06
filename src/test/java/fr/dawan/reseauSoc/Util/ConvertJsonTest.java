package fr.dawan.reseauSoc.Util;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import fr.dawan.reseauSoc.beans.Song;
import junit.framework.TestCase;

public class ConvertJsonTest extends TestCase {

	@Test
	public void testToJson() {
		Song song = new Song(1,360);
		String json = null;
		try {
			json = ConvertJson.toJson(song);
			System.out.println(json);
			assertEquals( "{\"number\":1, \"duration\":360}", json);
		} catch (JsonProcessingException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testToObject() {
		String json = "{\"number\":1, \"duration\":21}";
		try {
			Song ss = ConvertJson.toObject(json, Song.class);
			assertEquals(1, ss.getNumber());
			assertEquals(21, ss.getDuration());
		} catch (IOException e) {
			fail(e.getMessage());
		}
		

	}


}
