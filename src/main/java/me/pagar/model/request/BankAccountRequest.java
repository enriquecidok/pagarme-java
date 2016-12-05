package me.pagar.model.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pagar.enumeration.DocumentType;
import me.pagar.model.BankAccount;

@Data
@NoArgsConstructor
public class BankAccountRequest extends BankAccount implements RequestObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5862666574107498806L;

	@Builder
	public BankAccountRequest(String bankCode, String agencia, String agenciaDv, String conta, String contaDv,
			DocumentType documentType, String documentNumber, String legalName, Boolean chargeTransferFees) {
		super(bankCode, agencia, agenciaDv, conta, contaDv, documentType, documentNumber, legalName, chargeTransferFees);
	}

	
}
