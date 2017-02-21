package me.pagar.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType  implements EnumFieldConvertable{
	INVALID_PARAMETER("invalid_parameter"), ACTION_FORBIDDEN("action_forbidden"), INTERNAL_ERROR("internal_error"), NOT_FOUND("not_found");

	private String value;

	private ErrorType(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
	public String getField() {
		return "type";
	}
}
