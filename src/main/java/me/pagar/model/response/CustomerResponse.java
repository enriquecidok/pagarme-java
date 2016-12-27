package me.pagar.model.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.pagar.model.Address;
import me.pagar.model.Phone;

@Getter
@Setter(AccessLevel.PROTECTED)
public class CustomerResponse extends ResponseObjectImpl implements ResponseObject{

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
