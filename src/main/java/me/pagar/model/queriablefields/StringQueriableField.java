package me.pagar.model.queriablefields;

import lombok.Getter;

public class StringQueriableField implements EqualityQueriable<String>{

	@Getter private String key;
	public StringQueriableField(String key) {
		this.key = key;
	}

	public String getFormattedString(String value) {
		return value;
	}
}
