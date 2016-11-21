package me.pagar.model.request;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import me.pagar.model.CardAbstract;

public class CardRequest extends CardAbstract<CardRequest> implements RequestObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6177998031744400057L;
	private String number;
	private DateTime expirationDate;
	private String customerId;
	private String hash;
	private String cvv;
	
	public String getNumber() {
		return number;
	}
	public CardRequest setNumber(String number) {
		this.number = number;
		return this;
	}
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MMyy")
	public DateTime getExpirationDate() {
		return expirationDate;
	}
	public CardRequest setExpirationDate(DateTime expirationDate) {
		this.expirationDate = expirationDate;
		return this;
	}
	public String getCustomerId() {
		return customerId;
	}
	public CardRequest setCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}
	public String getHash() {
		return hash;
	}
	public CardRequest setHash(String hash) {
		this.hash = hash;
		return this;
	}
	public String getCvv() {
		return cvv;
	}
	public CardRequest setCvv(String cvv) {
		this.cvv = cvv;
		return this;
	}
	
	
}
