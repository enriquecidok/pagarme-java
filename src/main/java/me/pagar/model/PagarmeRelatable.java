package me.pagar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface PagarmeRelatable {

	/**
	 * Model´s path as seen in the Pagar.me path
	 * @return
	 */
	public String getId();
	@JsonIgnore
	public String getModelNamePlural();
	@JsonIgnore
	public String getModelNameSingular();
}
