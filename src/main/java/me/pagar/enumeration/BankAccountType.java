package me.pagar.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BankAccountType implements EnumFieldConvertable{
	CONTA_CORRENTE("conta_corrente"), CONTA_POUPANCA("conta_poupanca"), CONTA_CORRENTE_CONJUNTA("conta_corrente_conjunta"), CONTA_POUPANCA_CONJUNTA("conta_poupanca_conjunta");
	
	private String value;
	
	private BankAccountType(String value) {
		this.value = value;
	}
	
	@JsonValue
	public String getValue() {
		return value;
	}

	public String getField() {
		return "type";
	}
}
