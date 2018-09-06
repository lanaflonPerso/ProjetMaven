package fr.dawan.reseauSoc.Util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class ConvertJson {

	public static <T> T toObject(String json, Class<T> valueType) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		T obj = null;
		obj = mapper.readValue(json, valueType);

		return obj;
	}

	public static <T> String toJson(T objValue) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objValue);
		return str;
	}
	
	

}
