package me.pagar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pagar.model.request.RequestObject;
import me.pagar.model.response.ResponseObject;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
