package me.pagar.model.request;

import org.joda.time.DateTime;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import me.pagar.model.Address;
import me.pagar.model.PagarmeObject;
import me.pagar.model.Phone;

@Getter
public class CustomerRequest extends PagarmeObject implements RequestObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2806629590824783965L;

	private String documentNumber;
	private String name;
	private String email;
	@Setter private DateTime bornAt;
	@Setter private String gender;
	private Address address;
	private Phone phone;

	public CustomerRequest(@NonNull String documentNumber, @NonNull String name, @NonNull String email, @NonNull Address address, @NonNull Phone phone) {
		this.documentNumber = documentNumber;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public String getModelNamePlural() {
		return "customers";
	}

	public String getModelNameSingular() {
		return "customer";
	}

}
