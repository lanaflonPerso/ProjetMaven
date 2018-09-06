package fr.dawan.reseauSoc.Util;

import org.junit.Test;

import fr.dawan.reseauSoc.beans.Song;
import junit.framework.TestCase;

public class ConvertJsonTest extends TestCase {

	@Test
	public void toJsonTest() {
		Song song = new Song(1,360);
		String json = null;
		json = ConvertJson.getInstance().toJson(song);
		assertNotNull(json);
		System.out.println(json);
	}
	
	@Test
	public void toObjectTest() {
		Song song = null;
		String json = "{\"name\":\"Mahesh\", \"age\":21}";
		song = ConvertJson.getInstance().toObject(json);
		assertNotNull(song);
		System.out.println(song);
	}

}
