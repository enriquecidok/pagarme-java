package me.pagar.model.queriablefields;

import org.joda.time.DateTime;

import lombok.Getter;

public class DateTimeTimestampQueriableField implements RangeQueriable<DateTime> {

	@Getter private String key;
	public DateTimeTimestampQueriableField(String key) {
		this.key = key;
	}

	public String getFormattedString(DateTime value) {
		return String.valueOf(value.getMillis());
	}
}
