package me.pagar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pagar.enumeration.DocumentType;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
	public String getModelPath() {
		return "bank_account";
	}
	
	@Override
	public String getId() {
		return super.getId();
	}

}
