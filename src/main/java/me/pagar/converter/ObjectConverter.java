package me.pagar.converter;

import java.util.ArrayList;

import com.google.inject.ImplementedBy;

import me.pagar.exception.ParserException;
import me.pagar.model.response.ResponseObject;

@ImplementedBy(DefaultObjectConverter.class)
public interface ObjectConverter {

	public <T extends ResponseObject> ArrayList<T> jsonToObjects(String json, Class<T> clazz) throws ParserException;
	public <T extends ResponseObject> T jsonToObject(String json, Class<T> clazz) throws ParserException;
}
