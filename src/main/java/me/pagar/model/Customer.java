package me.pagar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Customer extends PagarmeObject {

	private String documentNumber;
	private String name;
	private String email;
	private String bornAt;
	private String gender;
	private Address address;
	private Phone phone;
	
	public String getModelPath() {
		return "customers";
	}
	
}
