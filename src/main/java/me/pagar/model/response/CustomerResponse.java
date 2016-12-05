package me.pagar.model.response;

import lombok.Builder;
import lombok.NoArgsConstructor;
import me.pagar.model.Address;
import me.pagar.model.Customer;
import me.pagar.model.Phone;

@NoArgsConstructor
public class CustomerResponse extends Customer implements ResponseObject{

	@Builder
	public CustomerResponse(String documentNumber, String name, String email, String bornAt, String gender,
			Address address, Phone phone) {
		super(documentNumber, name, email, bornAt, gender, address, phone);
	}
	
}
