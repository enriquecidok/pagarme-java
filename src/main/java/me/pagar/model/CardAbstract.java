package me.pagar.model;

import me.pagar.model.request.Request;
import me.pagar.model.response.Response;

public abstract class CardAbstract extends PagarmeObject implements Request, Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2587903266080648746L;
	private String holderName;

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
}
