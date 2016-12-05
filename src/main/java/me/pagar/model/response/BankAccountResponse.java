package me.pagar.model.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.pagar.enumeration.DocumentType;
import me.pagar.model.BankAccount;

@Data
@NoArgsConstructor
public class BankAccountResponse extends BankAccount implements ResponseObject{

	@Builder
	public BankAccountResponse(String bankCode, String agencia, String agenciaDv, String conta, String contaDv,
			DocumentType documentType, String documentNumber, String legalName, Boolean chargeTransferFees) {
		super(bankCode, agencia, agenciaDv, conta, contaDv, documentType, documentNumber, legalName, chargeTransferFees);
	}

	
}
