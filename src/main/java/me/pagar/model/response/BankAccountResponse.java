package me.pagar.model.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.pagar.enumeration.BankAccountType;

@Getter
@Setter(AccessLevel.PROTECTED)
public class BankAccountResponse extends ResponseObjectImpl implements ResponseObject{

	private String bankCode;
	private String agencia;
	private String agenciaDv;
	private String conta;
	private String contaDv;
	private BankAccountType type;
	private String documentNumber;
	private String legalName;
	private Boolean chargeTransferFees;

	public String getModelNamePlural() {
		return "bank_accounts";
	}

	public String getModelNameSingular() {
		return "bank_account";
	}
}
