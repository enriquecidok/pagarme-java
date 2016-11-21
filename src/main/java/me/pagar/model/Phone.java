package me.pagar.model;

import me.pagar.model.request.RequestObject;
import me.pagar.model.response.ResponseObject;

public class Phone implements RequestObject, ResponseObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8063840548727980750L;
	private String ddd;
	private String number;
	public String getDdd() {
		return ddd;
	}
	public Phone setDdd(String ddd) {
		this.ddd = ddd;
		return this;
	}
	public String getNumber() {
		return number;
	}
	public Phone setNumber(String number) {
		this.number = number;
		return this;
	}
	
	
}
