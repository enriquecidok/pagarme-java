package me.pagar.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Model {

	public String getId();
	public void setId(String id);
	public Boolean existsAtPagarme();
	
	/**
	 * Model´s path as seen in the Pagar.me path
	 * @return
	 */
	@JsonIgnore
	public String getModelNamePlural();
	@JsonIgnore
	public String getModelNameSingular();
}
