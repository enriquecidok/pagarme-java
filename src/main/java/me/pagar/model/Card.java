package me.pagar.model;

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

	public Card(String id, String object, String holderName) {
		super(id);
		this.holderName = holderName;
	}

}
