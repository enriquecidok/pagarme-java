package me.pagar.model;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Card extends PagarmeObject {

	private String holderName;

	public String getModelNamePlural() {
		return "cards";
	}

	public String getModelNameSingular() {
		return "card";
	}

	public Card(String id, String object, DateTime dateCreated, DateTime dateUpdated, String holderName) {
		super(id, object, dateCreated, dateUpdated);
		this.holderName = holderName;
	}

}
