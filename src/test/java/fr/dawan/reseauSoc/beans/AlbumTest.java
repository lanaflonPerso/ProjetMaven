package fr.dawan.reseauSoc.beans;

import org.junit.Test;

import junit.framework.TestCase;

public class AlbumTest extends TestCase {

	
	
	@Test
	public void testConstructeurDefault() {
		Album al = new Album();
		System.out.println(al.getClass());
		assertNotNull(al);
		//assertEquals(al.getNom(), null);
	}
	

}
