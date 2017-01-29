package me.pagar.model.facade;

import me.pagar.model.response.PayableResponse;

public class Payable {

	private PayableResponse attributes;
	private String id;

	public Payable(PayableResponse respose){
		this.attributes = respose;
		this.id = attributes.getId();
	}
}
