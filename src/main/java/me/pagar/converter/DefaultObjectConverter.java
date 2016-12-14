package me.pagar.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import me.pagar.model.request.RequestObject;
import me.pagar.model.response.ResponseObject;

public class DefaultObjectConverter implements ObjectConverter {

	private ObjectMapper mapper;
	
	protected DefaultObjectConverter(ObjectMapper mapper) {
		this.mapper = mapper;
		this.mapper
			.setSerializationInclusion(Include.NON_NULL)
			.registerModule(new JodaModule())
			.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public <T extends ResponseObject> T jsonToObject(String json, Class<T> clazz) throws ParserException {
		try {
			T mapped = mapper.readValue(json, clazz);
			return mapped;
		} catch (JsonParseException e) {
			throw new ParserException("Parse Exception: " + json, json);
		} catch (JsonMappingException e) {
			throw new ParserException("Mapping Exception: " + json, json);
		} catch (IOException e) {
			throw new ParserException("IOException: " + json, json);
		}
	}

	public String objectToJson(Object object) throws ParserException {
		try {
			String json = mapper.writeValueAsString(object);
			return json;
		} catch (JsonProcessingException e) {
			throw new ParserException("Object processing Exception: " + object, object);
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends ResponseObject> ArrayList<T> jsonToObjects(String json, Class<T> clazz) throws ParserException {
		try {
			ArrayList<T> mapped = mapper.readValue(json, ArrayList.class);
			return mapped;
		} catch (JsonParseException e) {
			throw new ParserException("Parse Exception: " + json, json);
		} catch (JsonMappingException e) {
			throw new ParserException("Mapping Exception: " + json, json);
		} catch (IOException e) {
			throw new ParserException("IOException: " + json, json);
		}
	}

	public <T extends RequestObject> String objectsToJson(Collection<T> objects) throws ParserException {
		try {
			String json = mapper.writeValueAsString(objects);
			return json;
		} catch (JsonProcessingException e) {
			throw new ParserException("Object processing Exception: " + objects, objects);
		}
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> objectToMap(Object object) {
		Map<String,Object> mappedObject = (Map<String, Object>)mapper.convertValue(object, Map.class);
		return mappedObject;
	}

}
