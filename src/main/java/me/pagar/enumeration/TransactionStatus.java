package me.pagar.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionStatus implements EnumFieldConvertable{

	PROCESSING("processing"), AUTHORIZED("authorized"), PAID("paid"), REFUNDED("refunded"), WAITING_PAYMENT("waiting_payment"), PENDING_REFUND("pending_refund"), REFUSED("refused");
	
	private String value;
	private TransactionStatus(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public String getField() {
		return "status";
	}

}
