package me.pagar.model.queriablefields;

import org.joda.time.DateTime;

public class DateTimeIsodateQueriableField implements RangeQueriable<DateTime>{

	private String key;

	public DateTimeIsodateQueriableField(String key) {
		this.key = key;
	}

	public String getFormattedString(DateTime value) {
		return value.toString();
	}

	public String getKey() {
		return key;
	}
}
