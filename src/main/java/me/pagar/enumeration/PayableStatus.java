package me.pagar.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PayableStatus implements EnumFieldConvertable{

	WAITING_FUNDS("waiting_funds"), PAID("paid");

	private String value;

	private PayableStatus(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public String getField() {
		return "status";
	}

}
