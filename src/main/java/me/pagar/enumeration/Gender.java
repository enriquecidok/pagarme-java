package me.pagar.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender implements EnumFieldConvertable {
	MALE("M"), FEMALE("F");
	
	private String value;
	
	private Gender(String value) {
		this.value = value;
	}
	
	@JsonValue
	public String getValue() {
		return value;
	}
	public String getField() {
		return "gender";
	}

}
