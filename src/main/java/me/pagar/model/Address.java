package me.pagar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.pagar.model.request.RequestObject;
import me.pagar.model.response.ResponseObject;

@AllArgsConstructor
@Getter
public class Address extends PagarmeObject implements RequestObject, ResponseObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3087003415236824005L;
	
	private String street;
	private String streetNumber;
	private String complementary;
	private String neighborhood;
	private String zipcode;
	
	public String getModelNamePlural() {
		return "addresses";
	}

	public String getModelNameSingular() {
		return "address";
	}
	
}
