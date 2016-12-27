package me.pagar.model;

import java.util.HashMap;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public abstract class PagarmeObject implements Model, PagarmeRelatable{
	
	@Setter(value=AccessLevel.PUBLIC) private String id;
	private String object;
	private DateTime dateCreated;
	private DateTime dateUpdated;

	public PagarmeObject(String id) {
		this.id = id;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Object> toMap() {
		ObjectMapper converter = new ObjectMapper()
			.setSerializationInclusion(Include.NON_NULL)
			.registerModule(new JodaModule())
			.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		HashMap<String, Object> converted = (HashMap<String, Object>)converter.convertValue(this, new HashMap<String, Object>().getClass());
		return converted;
	}
}
