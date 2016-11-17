package me.pagar.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import me.pagar.logging.Logger;
import me.pagar.model.request.Request;
import me.pagar.model.response.Response;

public class DefaultObjectMapper implements ObjectConverter {

	private ObjectMapper mapper;
	private Logger logger;
	
	@Inject
	public DefaultObjectMapper(ObjectMapper mapper, Logger logger) {
		this.logger = logger;
		this.mapper = mapper;
	}
	
	public <T extends Response> T jsonToObject(String json, Class<T> clazz) throws ParserException {
		try {
			T mapped = mapper.readValue(json, clazz);
			return mapped;
		} catch (JsonParseException e) {
			logger.logError(e.getMessage(), e);
			throw new ParserException("Parse Exception: " + json, json);
		} catch (JsonMappingException e) {
			logger.logError(e.getMessage(), e);
			throw new ParserException("Mapping Exception: " + json, json);
		} catch (IOException e) {
			logger.logError(e.getMessage(), e);
			throw new ParserException("IOException: " + json, json);
		}
	}

	public <T extends Request> String objectToJson(T object) throws ParserException {
		try {
			String json = mapper.writeValueAsString(object);
			return json;
		} catch (JsonProcessingException e) {
			logger.logError(e.getMessage(), e);
			throw new ParserException("Object processing Exception: " + object, object);
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends Response> ArrayList<T> jsonToObjects(String json, Class<T> clazz) throws ParserException {
		try {
			ArrayList<T> mapped = mapper.readValue(json, ArrayList.class);
			return mapped;
		} catch (JsonParseException e) {
			logger.logError(e.getMessage(), e);
			throw new ParserException("Parse Exception: " + json, json);
		} catch (JsonMappingException e) {
			logger.logError(e.getMessage(), e);
			throw new ParserException("Mapping Exception: " + json, json);
		} catch (IOException e) {
			logger.logError(e.getMessage(), e);
			throw new ParserException("IOException: " + json, json);
		}
	}

	public <T extends Request> String objectsToJson(Collection<T> objects) throws ParserException {
		try {
			String json = mapper.writeValueAsString(objects);
			return json;
		} catch (JsonProcessingException e) {
			logger.logError(e.getMessage(), e);
			throw new ParserException("Object processing Exception: " + objects, objects);
		}
	}

}
