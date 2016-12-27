package me.pagar.model.response;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import me.pagar.exception.ParserException;
import me.pagar.model.PagarmeObject;

public abstract class ResponseObjectImpl extends PagarmeObject implements ResponseObject {

	@SuppressWarnings("unchecked")
	public <T extends ResponseObject> T loadFromJson(String jsonString) throws ParserException {
		ObjectMapper converter = new ObjectMapper()
			.setSerializationInclusion(Include.NON_NULL)
			.registerModule(new JodaModule())
			.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			T mapped = (T)converter.readValue(jsonString, this.getClass());
			return mapped;
		} catch (JsonParseException e) {
			throw new ParserException("Parse Exception: " + jsonString, e);
		} catch (JsonMappingException e) {
			throw new ParserException("Parse Exception: " + jsonString, e);
		} catch (IOException e) {
			throw new ParserException("Parse Exception: " + jsonString, e);
		}
	}
}
