package me.pagar.model;

import me.pagar.model.request.RequestObject;
import me.pagar.model.response.ResponseObject;

public class SplitRule extends PagarmeObject<SplitRule> implements ResponseObject, RequestObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2023527027241606846L;
	private String recipientId;
	private Boolean chargeProcessingfee;
	private Boolean liable;
	private Integer percentage;
	private Integer amount;
	public String getRecipientId() {
		return recipientId;
	}
	public SplitRule setRecipientId(String recipientId) {
		this.recipientId = recipientId;
		return this;
	}
	public Boolean getChargeProcessingfee() {
		return chargeProcessingfee;
	}
	public SplitRule setChargeProcessingfee(Boolean chargeProcessingfee) {
		this.chargeProcessingfee = chargeProcessingfee;
		return this;
	}
	public Boolean getLiable() {
		return liable;
	}
	public SplitRule setLiable(Boolean liable) {
		this.liable = liable;
		return this;
	}
	public Integer getPercentage() {
		return percentage;
	}
	public SplitRule setPercentage(Integer percentage) {
		this.percentage = percentage;
		return this;
	}
	public Integer getAmount() {
		return amount;
	}
	public SplitRule setAmount(Integer amount) {
		this.amount = amount;
		return this;
	}
	
	
}
