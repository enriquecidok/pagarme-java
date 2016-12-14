package me.pagar.model.request;

import lombok.Getter;
import lombok.NonNull;
import me.pagar.model.Address;
import me.pagar.model.Customer;
import me.pagar.model.Phone;

@Getter
public class CustomerRequest extends Customer implements RequestObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2531021777117730384L;

	public CustomerRequest(@NonNull String documentNumber, @NonNull String name, @NonNull String email, String bornAt, String gender, @NonNull Address address, @NonNull Phone phone) {
		super(documentNumber, name, email, bornAt, gender, address, phone);
	}

}
