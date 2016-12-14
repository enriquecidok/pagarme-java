package me.pagar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Customer extends PagarmeObject {

	private String documentNumber;
	private String name;
	private String email;
	private String bornAt;
	private String gender;
	private Address address;
	private Phone phone;
	
	public String getModelNamePlural() {
		return "customers";
	}

	public String getModelNameSingular() {
		return "customer";
	}
}
