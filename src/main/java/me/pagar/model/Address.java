package me.pagar.model;

import me.pagar.model.request.Request;
import me.pagar.model.response.Response;

public class Address implements Request, Response{

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
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getComplementary() {
		return complementary;
	}
	public void setComplementary(String complementary) {
		this.complementary = complementary;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
