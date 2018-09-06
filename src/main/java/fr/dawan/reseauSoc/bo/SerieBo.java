package fr.dawan.reseauSoc.bo;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.dawan.reseauSoc.beans.Serie;
import fr.dawan.reseauSoc.fixtures.SerieFixture;


public class SerieBo {

	public void save() {
		
	}
	
	public void update() {
		
	}
	
	public void find(String type, String element ) {
		if (type.equals("releaseDate")) {
			
		} else if (type.equals("name")) {
			
		} else if (type.equals("category")) {
			
		}
	}
	
	public static String findAll() {
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
//		objectMapper.setDateFormat(df);

		SerieFixture fixture= new SerieFixture();
		
		List<Serie> list= fixture.listSerie();
		
		System.out.println(mappers(list));
		
		return mappers(list);
	}
	
	private static String mappers(List<Serie> serie) {
		String asString = null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			asString = objectMapper.writeValueAsString(serie);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asString;
	}
	
	private static String mapper(Serie serie) {
		String asString = null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			asString = objectMapper.writeValueAsString(serie);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asString;
	}
}