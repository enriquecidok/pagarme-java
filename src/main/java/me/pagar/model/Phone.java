package me.pagar.model;

import me.pagar.model.request.Request;
import me.pagar.model.response.Response;

public class Phone implements Request, Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8063840548727980750L;
	private String ddd;
	private String number;
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
