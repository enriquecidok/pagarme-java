package me.pagar.model.response;

import me.pagar.exception.ParserException;
import me.pagar.model.Model;

public interface ResponseObject extends Model {

	public <T extends ResponseObject> T loadFromJson(String jsonString) throws ParserException;
}
