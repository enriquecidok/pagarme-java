package me.pagar.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class Phone extends PagarmeObject{

	private String ddd;
	private String number;

	public Phone(@NonNull String ddd, @NonNull String number) {
		this.ddd = ddd;
		this.number = number;
	}

	public String getModelNamePlural() {
		return "phones";
	}

	public String getModelNameSingular() {
		return "phone";
	}
}
