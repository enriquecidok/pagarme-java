package me.pagar.model.request;

import lombok.Builder;
import lombok.NoArgsConstructor;
import me.pagar.model.Address;
import me.pagar.model.Customer;
import me.pagar.model.Phone;

@NoArgsConstructor
public class CustomerRequest extends Customer implements RequestObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2531021777117730384L;

	@Builder
	public CustomerRequest(String documentNumber, String name, String email, String bornAt, String gender,
			Address address, Phone phone) {
		super(documentNumber, name, email, bornAt, gender, address, phone);
	}
	
}
