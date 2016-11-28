package me.pagar.model;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer extends PagarmeObject {

	private String documentNumber;
	private String name;
	private String email;
	private String bornAt;
	private String gender;
	private Address address;
	private Phone phone;
	
	@Builder
	protected Customer(String id, String object, DateTime dateCreated, DateTime dateUpdated, String documentNumber,
			String name, String email, String bornAt, String gender, Address address, Phone phone) {
		super(id, object, dateCreated, dateUpdated);
		this.documentNumber = documentNumber;
		this.name = name;
		this.email = email;
		this.bornAt = bornAt;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
	}
	
	
}
