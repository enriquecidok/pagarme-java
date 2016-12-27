package me.pagar.model.queriablefields;

import me.pagar.enumeration.EnumFieldConvertable;

public class EnumQueriableField<T extends EnumFieldConvertable> implements EqualityQueriable<T>{

	private String key;

	public EnumQueriableField(String key){
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public String getFormattedString(T value) {
		return value.getField();
	}

}
