package me.pagar.model;

import org.joda.time.DateTime;

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
	
	public Boolean existsAtPagarme(){
		return this.getId() != null && !this.getId().isEmpty();
	}

	public PagarmeObject(String id) {
		this.id = id;
	}
}
