package me.pagar.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CardBrand implements EnumFieldConvertable{
	MASTERCARD("mastercard"), VISA("visa"), AMEX("amex"), JCB("jcb"), ELO("elo"), HIPERCARD("hipercard"), DINERS("diners"), AURA("aura"), DISCOVER("discover");

	private String value;

	private CardBrand(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public String getField() {
		return "brand";
	}

}
