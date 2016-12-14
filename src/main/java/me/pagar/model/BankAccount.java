package me.pagar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.pagar.enumeration.DocumentType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class BankAccount extends PagarmeObject {

	private String bankCode;
	private String agencia;
	private String agenciaDv;
	private String conta;
	private String contaDv;
	private DocumentType documentType;
	private String documentNumber;
	private String legalName;
	private Boolean chargeTransferFees;
	
	public String getModelNamePlural() {
		return "bank_account";
	}

	public String getModelNameSingular() {
		return "bank_account";
	}

}
