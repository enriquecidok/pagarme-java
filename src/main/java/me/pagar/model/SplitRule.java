package me.pagar.model;

import me.pagar.model.request.Request;
import me.pagar.model.response.Response;

public class SplitRule extends PagarmeObject implements Response, Request {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2023527027241606846L;
	private String recipientId;
	private String chargeProcessingfee;
	private String liable;
	private String percentage;
	private String amount;
	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	public String getChargeProcessingfee() {
		return chargeProcessingfee;
	}
	public void setChargeProcessingfee(String chargeProcessingfee) {
		this.chargeProcessingfee = chargeProcessingfee;
	}
	public String getLiable() {
		return liable;
	}
	public void setLiable(String liable) {
		this.liable = liable;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
