package me.pagar.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public abstract class Card extends PagarmeObject {

	private String holderName;

	public String getModelNamePlural() {
		return "cards";
	}

	public String getModelNameSingular() {
		return "card";
	}

	protected void setHolderName(String holderName) {
		this.holderName = holderName;
	}
}
