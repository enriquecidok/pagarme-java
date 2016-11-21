package me.pagar.model.request;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import me.pagar.model.TransactionAbstract;

public class TransactionRequest extends TransactionAbstract<TransactionRequest> implements RequestObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6464094814474395030L;
	
	@Override
	@JsonUnwrapped(prefix="card_")
	public CardRequest getCard() {
		return super.getCard();
	}
	
}
