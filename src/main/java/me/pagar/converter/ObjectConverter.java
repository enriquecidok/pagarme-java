package me.pagar.converter;

import java.util.ArrayList;
import java.util.Collection;

import me.pagar.model.request.Request;
import me.pagar.model.response.Response;

public interface ObjectConverter {

	public <T extends Response> T jsonToObject(String json, Class<T> clazz) throws ParserException;
	public <T extends Request> String objectToJson(T object) throws ParserException;
	
	public <T extends Response> ArrayList<T> jsonToObjects(String json, Class<T> clazz) throws ParserException;
	public <T extends Request> String objectsToJson(Collection<T> object) throws ParserException;
}
