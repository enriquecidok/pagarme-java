package me.pagar.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TransferInterval implements EnumFieldConvertable{

	DAILY("daily"), WEEKLY("weekly"), MONTHLY("monthly");

	private String value;

	private TransferInterval(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public String getField() {
		return "transfer_interval";
	}

}
