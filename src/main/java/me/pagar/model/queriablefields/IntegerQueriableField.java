package me.pagar.model.queriablefields;

import lombok.Getter;

public class IntegerQueriableField implements EqualityQueriable<Integer>, RangeQueriable<Integer>{

	@Getter private String key;
	public IntegerQueriableField(String key) {
		this.key = key;
	}

	public String getFormattedString(Integer value) {
		return value.toString();
	}
}
