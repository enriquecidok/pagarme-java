package me.pagar.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter(AccessLevel.PROTECTED)
public class Address extends PagarmeObject {

	private String street;
	private String streetNumber;
	private String complementary;
	private String neighborhood;
	private String zipcode;
	private String coutry;
	private String city;
	private String state;

	/**
	 * the complementary param may be null
	 * @param street
	 * @param streetNumber
	 * @param complementary
	 * @param neighborhood
	 * @param zipcode
	 */
	public Address(@NonNull String street, @NonNull String streetNumber, @NonNull String neighborhood, @NonNull String zipcode, String complementary){
		this.street = street;
		this.streetNumber = streetNumber;
		this.neighborhood = neighborhood;
		this.complementary = complementary;
		this.zipcode = zipcode;
	}

	public Address(@NonNull String street, @NonNull String streetNumber, @NonNull String neighborhood, @NonNull String city, @NonNull String state, String complementary){
		this.street = street;
		this.streetNumber = streetNumber;
		this.neighborhood = neighborhood;
		this.complementary = complementary;
		this.city = city;
		this.state = state;
	}

	public String getModelNamePlural() {
		return "addresses";
	}

	public String getModelNameSingular() {
		return "address";
	}
}
