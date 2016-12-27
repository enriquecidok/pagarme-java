package me.pagar.model.queriablefields;

public interface QueriableFieldTyped<T> {

	public String getKey();
	public String getFormattedString(T value);
}
