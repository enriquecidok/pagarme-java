package me.pagar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.pagar.model.request.RequestObject;
import me.pagar.model.response.ResponseObject;

@AllArgsConstructor
@Getter
public class Phone extends PagarmeObject implements RequestObject, ResponseObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8063840548727980750L;
	private String ddd;
	private String number;
	
	public String getModelNamePlural() {
		return "phones";
	}

	public String getModelNameSingular() {
		return "phone";
	}
}
