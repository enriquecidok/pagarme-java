package me.pagar.model.request;

import me.pagar.model.CardAbstract;

public class CardRequest extends CardAbstract implements Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6177998031744400057L;
	private String number;
	private String expirationDate;
	private String customerId;
	private String hash;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	
}
