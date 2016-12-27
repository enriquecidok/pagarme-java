package me.pagar.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentType implements EnumFieldConvertable {
	CPF("cpf"), CNPJ("cnpj");
	
	private String value;
	
	private DocumentType(String value) {
		this.value = value;
	}
	
	@JsonValue
	public String getValue() {
		return value;
	}

	public String getField() {
		return "document_type";
	}
}
