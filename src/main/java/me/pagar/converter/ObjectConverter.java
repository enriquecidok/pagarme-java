package me.pagar.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.google.inject.ImplementedBy;

import me.pagar.model.request.RequestObject;
import me.pagar.model.response.ResponseObject;

@ImplementedBy(DefaultObjectConverter.class)
public interface ObjectConverter {

	public <T extends ResponseObject> T jsonToObject(String json, Class<T> clazz) throws ParserException;
	public String objectToJson(Object object) throws ParserException;
	
	public <T extends ResponseObject> ArrayList<T> jsonToObjects(String json, Class<T> clazz) throws ParserException;
	public <T extends RequestObject> String objectsToJson(Collection<T> object) throws ParserException;
	
	public Map<String, Object> objectToMap(Object object);
	
}
