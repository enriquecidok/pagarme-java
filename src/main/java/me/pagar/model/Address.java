package me.pagar.model;

import me.pagar.model.request.RequestObject;
import me.pagar.model.response.ResponseObject;

public class Address implements RequestObject, ResponseObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3087003415236824005L;
	private String street;
	private String streetNumber;
	private String complementary;
	private String neighborhood;
	private String zipcode;
	public String getStreet() {
		return street;
	}
	public Address setStreet(String street) {
		this.street = street;
		return this;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public Address setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
		return this;
	}
	public String getComplementary() {
		return complementary;
	}
	public Address setComplementary(String complementary) {
		this.complementary = complementary;
		return this;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public Address setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
		return this;
	}
	public String getZipcode() {
		return zipcode;
	}
	public Address setZipcode(String zipcode) {
		this.zipcode = zipcode;
		return this;
	}
	
	
}
